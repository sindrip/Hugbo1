package is.hi.hirslan.repository;

import is.hi.hirslan.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */

public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Nær í öll Course
     * @return listi af Course
     */
    List<Course> findAll();

    /**
     * Bætir við Course
     * @param course
     */
    Course save (Course course);

    /**
     * Sækir Course eftir langtNumer (PK)
     * @param langtNumer
     */
    Course findByLangtNumer(String langtNumer);
}
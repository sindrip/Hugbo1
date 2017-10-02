package is.hi.byrjun.repository;

import is.hi.byrjun.model.Course;
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
     * Sækir Course eftir langtNumer
     * @param langtNumer
     */
    Course findByLangtNumer(String langtNumer);
}

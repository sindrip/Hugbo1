package is.hi.hirslan.repository;

import is.hi.hirslan.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date Október 2017
 * @description Repository fyrir allan áfanga. Sér um tengingar við gagnagrunn
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
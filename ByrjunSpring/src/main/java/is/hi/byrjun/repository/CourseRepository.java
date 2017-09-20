package is.hi.byrjun.repository;

import is.hi.byrjun.model.Course;

import java.util.List;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 */

public interface CourseRepository {

    /**
     * Nær í öll Course
     * @return listi af Course
     */
    List<Course> getAll();

    /**
     * Bætir við Course
     * @param course
     */
    void add (Course course);

    /**
     * Sækir Course eftir langtNumer
     * @param langtNumer
     */
    Course getById(String langtNumer);
}

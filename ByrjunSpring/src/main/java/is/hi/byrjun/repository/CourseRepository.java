package is.hi.byrjun.repository;

import is.hi.byrjun.model.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> getAll();

    void add (Course course);

    Course getById(String langtNumer);
}

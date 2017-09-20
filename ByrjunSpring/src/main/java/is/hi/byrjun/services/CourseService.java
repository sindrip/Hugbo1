package is.hi.byrjun.services;

import is.hi.byrjun.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> allCourse();

    public List<Course> searchCourse(String val);

}

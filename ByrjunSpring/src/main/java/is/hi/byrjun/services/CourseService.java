package is.hi.byrjun.services;

import is.hi.byrjun.model.Course;

import java.util.List;

public interface CourseService {

    public List<Course> allCourse();

    public Course singleCourse(String langtNumer);

    public List<Course> searchCourse(String val);

}

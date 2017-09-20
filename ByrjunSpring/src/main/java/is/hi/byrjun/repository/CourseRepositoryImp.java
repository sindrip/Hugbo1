package is.hi.byrjun.repository;

import is.hi.byrjun.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryImp implements CourseRepository {
    private final List<Course> course;

    public CourseRepositoryImp() {
        this.course = new ArrayList<Course>();
        this.course.add( new Course("5051IÐN101G20176", "IÐN101G", "Rekstrarfræði"));
        this.course.add( new Course("5051TÖL303G20176", "TÖL303G", "Gagnasafnsfræði"));
        this.course.add( new Course("5055STÆ302G20176", "STÆ302G", "Stærðfræðigreining III"));
        this.course.add( new Course("5051HBV401G20180", "HBV401G", "Þróun Hugbúnaðar"));
        this.course.add( new Course("5051HBV501G20176", "HBV501G", "Hugbúnaðarverkefni 1"));


    }

    @Override
    public List<Course> getAll() {
        return course;
    }

    @Override
    public void add(Course course) {
        this.course.add(course);
    }
}


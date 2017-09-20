package is.hi.byrjun.services;

import is.hi.byrjun.model.Course;
import is.hi.byrjun.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseRepository courseRep;

    @Override
    public List<Course> allCourse() {
        return courseRep.getAll();
    }

    @Override
    public Course singleCourse(String langtNumer) {
        return courseRep.getById(langtNumer);
    }

    @Override
    public List<Course> searchCourse(String val) {
        List<Course> listi = this.courseRep.getAll();
        ArrayList<Course> retList = new ArrayList<Course>();
        for (int i = 0; i < listi.size(); i++) {
            if (listi.get(i).getNafn().toLowerCase().contains(val.toLowerCase())) {
                retList.add(listi.get(i));
            } else if (listi.get(i).getNumer().toLowerCase().contains(val.toLowerCase())) {
                retList.add(listi.get(i));
            } else if (listi.get(i).getLangtNumer().toLowerCase().contains(val.toLowerCase())) {
                retList.add(listi.get(i));
            }
        }
        return retList;
    }
}

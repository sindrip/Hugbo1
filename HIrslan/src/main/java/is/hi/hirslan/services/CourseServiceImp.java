package is.hi.hirslan.services;

import is.hi.hirslan.model.Course;
import is.hi.hirslan.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 */

@Service
public class CourseServiceImp implements CourseService {

    /**
     * CourseRepository implementað á runtime af Spring
     */
    @Autowired
    CourseRepository courseRep;

    /**
     * Skilar öllum Courses í courseRep
     *
     * @return listi af Courses
     */
    @Override
    public List<Course> allCourse() {
        return courseRep.findAll();
    }

    /**
     * Skilar einu Course úr courseRep eftir langtNumer
     *
     * @return single Course
     */
    @Override
    public Course singleCourse(String langtNumer) {
        return courseRep.findByLangtNumer(langtNumer);
    }

    /**
     * Skilar Course lista af öllum Courses sem uppfylla ákveðin leitarskilyrði
     *
     * @return listi af Courses
     */
    @Override
    public List<Course> searchCourse(String val) {
        List<Course> listi = this.courseRep.findAll();

        return listi.stream()
                .filter(c -> c.getLangtNumer().toLowerCase().contains(val.toLowerCase())
                        || c.getNumer().toLowerCase().contains(val.toLowerCase())
                        || c.getNafn().toLowerCase().contains(val.toLowerCase())
                        || c.getKennslumisseri().toLowerCase().contains(val.toLowerCase())
                        || c.getNamsstig().toLowerCase().contains(val.toLowerCase())
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean erALifi() {
        return true;
    }
}
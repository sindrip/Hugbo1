package is.hi.hirslan.services;

import is.hi.hirslan.model.Course;
import is.hi.hirslan.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 * @description Service klasi fyrir CourseRepository.
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

    /*
        * @description Skilar öllum námskeiðum.
        * @param Nothing
        * @return List<course>
     */
    @Override
    public List<Course> allCourse() {
        return courseRep.findAll();
    }

    /**
     * Skilar einu Course úr courseRep eftir langtNumer
     *  @param LangtNumer fyrir course.
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

    /*
        @description Leitar að námskeiðum eftir leitarstreng
        @param Strengur til að leita.
        @return List<Course> Listi af öllum áföngum sem leitarstrengurinn á við um.
     */
    @Override
    public List<Course> searchCourse(String val) {
        List<Course> listi = this.courseRep.findAll();

        return listi.stream()
                .filter(c -> c.getLangtNumer().toLowerCase().contains(val.toLowerCase())
                        || c.getNumer().toLowerCase().contains(val.toLowerCase())
                        || c.getNafn().toLowerCase().contains(val.toLowerCase())
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean erALifi() {
        return true;
    }
}
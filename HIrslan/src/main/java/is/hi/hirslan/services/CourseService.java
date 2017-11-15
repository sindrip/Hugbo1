package is.hi.hirslan.services;

import is.hi.hirslan.model.Course;

import java.util.List;

/**
 *
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Þjónusta sem talar við Course Repository
 */

public interface CourseService {

    /**
     * Skilar öllum Courses í courseRep
     *
     * @return listi af Courses
     */
    public List<Course> allCourse();

    /**
     * Skilar einu Course úr courseRep eftir langtNumer
     *
     * @return single Course
     */
    public Course singleCourse(String langtNumer);

    /**
     * Skilar Course lista af öllum Courses sem uppfylla ákveðin leitarskilyrði
     *
     * @return listi af Courses
     */
    public List<Course> searchCourse(String val);

    public boolean erALifi();
}
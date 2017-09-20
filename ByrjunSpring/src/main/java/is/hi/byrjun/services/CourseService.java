package is.hi.byrjun.services;

import is.hi.byrjun.model.Course;

import java.util.List;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
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
     * Skilar einu Coursei úr courseRep eftir langtNumer
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

}

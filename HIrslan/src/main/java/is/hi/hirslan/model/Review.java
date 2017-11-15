package is.hi.hirslan.model;

import javax.persistence.*;
import java.util.Date;

/**
 *
 /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Review klasinn inniheldur, nafn, námskeiðsnúmer og langt námskeiðsnúmer
 */

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Auto incremented tala sem er primary key fyrir hverja umsögn
    @ManyToOne
    @JoinColumn(name="course", referencedColumnName="langtNumer")
    private Course course;
    //Heldur utan um áfangann sem viðkomandi umsögn tilheyrir
    private Integer rating;
    //Meðaleinkunn frá öllum umsögnum um áfangann
    private String author;
    //Hver skrifaði umsögnina
    private Date createdOn;
    //Hvenær umsögnin var skrifuð
    private String mainText;
    //Meginatriði í umsögninni. Það er textinn á bakvið umsögnina

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    @Override
    public String toString() {
        return String.format("Aðaltexti:" + mainText);
    }

}
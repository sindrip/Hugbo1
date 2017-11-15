package is.hi.hirslan.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * /**
 * @author Sindri Pétur Ingimundarso:email spi4@hi.is,
 * @author Ketill Guðmundsson:email keg13@hi.is,
 * @author Björn Guðmundsson:email bjg49@hi.is
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Course klasinn inniheldur, nafn, námskeiðsnúmer og langt námskeiðsnúmer
 */
@Entity
public class Course {

    @Id
    private String langtNumer;
    //langtNumer er primary key fyrir áfanga. Hver áfangi hefur sitt eigið langt númer
    private String numer;
    //Stytting á langt númer.
    private String nafn;
    //Nafnið á áfanganum
    private double einingar;
    //Segir til um hversu margar ECTS einingar viðkomandi áfangi samsvarar
    private String url;
    //Hlekkur á síðu áfangans í kennsluskrá
    @ColumnDefault("'-1.0'")
    @Column(name = "averageRank")
    private double averageRank = -1.0;

    public String getNafn() {
        return nafn;
    }

    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getLangtNumer() {
        return langtNumer;
    }

    public void setLangtNumer(String langtNumer) {
        this.langtNumer = langtNumer;
    }

    public double getAverageRank() {
        return averageRank;
    }

    public void setAverageRank(double averageRank) {
        this.averageRank = averageRank;
    }

    public double getEiningar() {
        return einingar;
    }

    public void setEiningar(int einingar) {
        this.einingar = einingar;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("<BR>" + "Nafn: " + nafn + "<BR>"
                + "Námskeiðsnúmer: " + numer);
    }
}
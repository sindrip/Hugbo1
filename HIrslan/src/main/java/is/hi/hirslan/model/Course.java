package is.hi.hirslan.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Course klasinn inniheldur, nafn, námskeiðsnúmer og langt námskeiðsnúmer
 */
@Entity
public class Course {

    @Id
    private String langtNumer;
    private String numer;
    private String nafn;
    private double einingar;
    private String kennslumisseri;
    private String namsstig;
    private String url;
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

    public String getKennslumisseri() {
        return kennslumisseri;
    }

    public void setKennslumisseri(String kennslumisseri) {
        this.kennslumisseri = kennslumisseri;
    }

    public String getNamsstig() {
        return namsstig;
    }

    public void setNamsstig(String namsstig) {
        this.namsstig = namsstig;
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
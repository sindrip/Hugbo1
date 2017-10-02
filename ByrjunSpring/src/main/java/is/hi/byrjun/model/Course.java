package is.hi.byrjun.model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Course klasinn inniheldur, nafn, námskeiðsnúmer og langt námskeiðsnúmer
 */
@Entity
@Table (name = "Course")
public class Course {

    @Id
    private String langtNumer;
    private String nafn;
    private String numer;

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

    @Override
    public String toString() {
        return String.format("<BR>" + "Nafn: " + nafn + "<BR>"
                + "Námskeiðsnúmer: " + numer);
    }


}

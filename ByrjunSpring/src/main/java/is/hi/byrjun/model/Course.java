package is.hi.byrjun.model;

/**
 *
 * @author Sindri Pétur Ingimundarson, Ketill Guðmundsson, Björn Guðmundsson, Ævar Aðalsteinsson
 * @date september 2017 HBV501G Hugbúnaðarverkefni 1 Háskóli Íslands
 *
 * Course klasinn inniheldur, nafn, námskeiðsnúmer og langt námskeiðsnúmer
 */

public class Course {

    private String nafn;
    private String numer;
    private String langtNumer;


    public Course(String langtNumer, String numer, String nafn) {
        this.setNafn(nafn);
        this.setNumer(numer);
        this.setLangtNumer(langtNumer);
    }

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

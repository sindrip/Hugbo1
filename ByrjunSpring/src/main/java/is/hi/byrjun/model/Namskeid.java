package is.hi.byrjun.model;

public class Namskeid {

    private String nafn;
    private String numer;


    public Namskeid(String nafn, String numer) {
        this.setNafn(nafn);
        this.setNumer(numer);
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

    @Override
    public String toString() {
        return String.format("<BR>" + "Nafn: " + nafn + "<BR>"
                + "Námskeiðsnúmer: " + numer);
    }

}

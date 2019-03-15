package training.endava.app.domain;

public class Adress {
    private Integer id;
    private String adresa;
    private String localitate;
    private String oras;

    public Adress(Integer id, String adresa, String localitate, String oras) {
        this.id = id;
        this.adresa = adresa;
        this.localitate = localitate;
        this.oras = oras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", adresa='" + adresa + '\'' +
                ", localitate='" + localitate + '\'' +
                ", oras='" + oras + '\'' +
                '}';
    }
}

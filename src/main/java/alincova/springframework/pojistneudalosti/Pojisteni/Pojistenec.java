package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;

@SuppressWarnings("ALL")
@Entity
public class Pojistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    private String Jmeno;
    private String Prijmeni;
    private int Vek;


    @ManyToMany(mappedBy = "pojistenci")
    private Set<Pojisteni> pojisteni = new HashSet<>();

    public Pojistenec() {
    }

    public Pojistenec(String jmeno, String prijmeni, int vek) {
        Jmeno = jmeno;
        Prijmeni = prijmeni;
        Vek = vek;
    }


    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getJmeno() {
        return Jmeno;
    }

    public void setJmeno(String jmeno) {
        Jmeno = jmeno;
    }

    public String getPrijmeni() {
        return Prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        Prijmeni = prijmeni;
    }

    public int getVek() {
        return Vek;
    }

    public void setVek(int vek) {
        Vek = vek;
    }

    public java.util.Set<Pojisteni> getPojisteni() {
        return pojisteni;
    }

    public void setPojisteni(java.util.Set<Pojisteni> pojisteni) {
        this.pojisteni = pojisteni;
    }

    @Override
    public String toString() {
        return "Pojistenec{" +
                "ID=" + ID +
                ", Jmeno='" + Jmeno + '\'' +
                ", Prijmeni='" + Prijmeni + '\'' +
                ", Vek=" + Vek +
                ", pojisteni=" + pojisteni +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojistenec that = (Pojistenec) o;

        if (ID != null ? !ID.equals(that.ID) : that.ID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }
}

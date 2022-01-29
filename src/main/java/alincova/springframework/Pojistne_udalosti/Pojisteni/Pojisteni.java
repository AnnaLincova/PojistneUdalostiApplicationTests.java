package alincova.springframework.Pojistne_udalosti.Pojisteni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Id;


@Entity
public class Pojisteni {

    private String nazev;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @ManyToMany
    @JoinTable(name = "pojistenec_pojisteni", joinColumns = @JoinColumn(name = "pojisteni_ID"),
            inverseJoinColumns = @JoinColumn(name = "pojistenec_ID"))
    private Set<Pojistenec> pojistenci = new HashSet<>();


    public Pojisteni() {
    }

    public Pojisteni(String nazev) {
        this.nazev = nazev;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }


    public Set<Pojistenec> getPojistenci() {
        return pojistenci;
    }

    public void setPojistenci(Set<Pojistenec> pojistenci) {
        this.pojistenci = pojistenci;
    }

    @Override
    public String toString() {
        return "Pojisteni{" +
                "nazev='" + nazev + '\'' +
                ", ID=" + ID +
                ", pojistenci=" + pojistenci +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojisteni pojisteni = (Pojisteni) o;

        return ID != null ? ID.equals(pojisteni.ID) : pojisteni.ID == null;
    }

    @Override
    public int hashCode() {
        return ID != null ? ID.hashCode() : 0;
    }
}


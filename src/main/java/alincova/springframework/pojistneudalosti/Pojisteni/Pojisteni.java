package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;

@Entity
public class Pojisteni {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinTable(name = "pojistenec_id")
    private Pojistenec pojistenec;

    @OneToOne(mappedBy = "pojisteni")
    private Smlouva smlouva;

    public Pojisteni() {
    }

    public Pojisteni(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pojistenec getPojistenec() {
        return pojistenec;
    }

    public void setPojistenec(Pojistenec pojistenec) {
        this.pojistenec = pojistenec;
    }

    public Smlouva getSmlouva() {
        return smlouva;
    }

    public void setSmlouva(Smlouva smlouva) {
        this.smlouva = smlouva;
    }
}


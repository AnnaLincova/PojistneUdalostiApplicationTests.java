package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;

@Entity
public class Pojisteni {

    private TypPojisteni type;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinTable(name = "pojistenec_id")
    private Pojistenec pojistenec;

    @OneToOne(mappedBy = "pojisteni")
    private Smlouva smlouva;

    public Pojisteni(TypPojisteni type) {
        this.type = type;
    }

    public Pojisteni() {

    }

    public TypPojisteni getType() {
        return type;
    }

    public void setType(TypPojisteni type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


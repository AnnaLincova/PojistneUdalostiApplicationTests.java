package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class Smlouva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Instant dateOfConclusion;
    private Instant dateOfExpiration;

    @ManyToOne
    @JoinTable(name = "pojistenec_id")
    private Pojistenec pojistenec;

    @OneToOne
    @JoinTable(name = "pojisteni_id")
    private Pojisteni pojisteni;

    public Smlouva() {
    }

    public Smlouva(String dateOfConclusion, String dateOfExpiration) {
        this.dateOfConclusion = Instant.parse(dateOfConclusion);
        this.dateOfExpiration = Instant.parse(dateOfExpiration);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(Instant dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public Instant getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Instant dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public Pojistenec getPojistenec() {
        return pojistenec;
    }

    public void setPojistenec(Pojistenec pojistenec) {
        this.pojistenec = pojistenec;
    }

    public Pojisteni getPojisteni() {
        return pojisteni;
    }

    public void setPojisteni(Pojisteni pojisteni) {
        this.pojisteni = pojisteni;
    }
}

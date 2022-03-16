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
    private TypPojisteni type;

    @ManyToOne
    @JoinTable(name = "pojistenec_id")
    private Pojistenec pojistenec;

    public Smlouva() {
    }

    public Smlouva(Instant dateOfConclusion, Instant dateOfExpiration, TypPojisteni type) {
        this.id = id;
        this.dateOfConclusion = dateOfConclusion;
        this.dateOfExpiration = dateOfExpiration;
        this.type = type;
        this.pojistenec = pojistenec;
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

    public TypPojisteni getType() {
        return type;
    }

    public void setType(TypPojisteni type) {
        this.type = type;
    }

    public Pojistenec getPojistenec() {
        return pojistenec;
    }

    public void setPojistenec(Pojistenec pojistenec) {
        this.pojistenec = pojistenec;
    }
}

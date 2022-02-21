package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Smlouva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dateOfConclusion;
    private LocalDate dateOfExpiration;

    @ManyToOne
    @JoinTable(name = "pojistenec_id")
    private Pojistenec pojistenec;

    @OneToOne
    @JoinTable(name = "pojisteni_id")
    private Pojisteni pojisteni;

    public Smlouva() {
    }

    public Smlouva(String dateOfConclusion, String dateOfExpiration) {
        this.dateOfConclusion = LocalDate.parse(dateOfConclusion);
        this.dateOfExpiration = LocalDate.parse(dateOfExpiration);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
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

package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Id;


@Entity
public class Pojisteni {

    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    @JoinTable(name = "pojistenec_pojisteni", joinColumns = @JoinColumn(name = "pojisteni_ID"),
            inverseJoinColumns = @JoinColumn(name = "pojistenec_ID"))
    private Set<Pojistenec> pojistenci = new HashSet<>();


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


    public Set<Pojistenec> getPojistenci() {
        return pojistenci;
    }

    public void setPojistenci(Set<Pojistenec> pojistenci) {
        this.pojistenci = pojistenci;
    }


}


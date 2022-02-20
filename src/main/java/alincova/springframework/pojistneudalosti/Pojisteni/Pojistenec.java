package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
@Entity
public class Pojistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private int age;

    @OneToMany(mappedBy = "pojistenec")
    private Set<Pojisteni> pojisteni = new HashSet<>();

    @OneToMany(mappedBy = "pojistenec")
    private Set<Smlouva> smlouva = new HashSet<>();

    public Pojistenec() {
    }

    public Pojistenec(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public void setName(String jmeno) {
        this.name = jmeno;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Pojisteni> getPojisteni() {
        return pojisteni;
    }

    public String getPojisteniName() {
        StringBuilder sb = new StringBuilder();
        pojisteni.forEach(poj ->
        {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(poj.getName());
        });
        return sb.toString();
    }

    public Set<Smlouva> getSmlouva() {
        return smlouva;
    }

    public void setSmlouva(Set<Smlouva> smlouva) {
        this.smlouva = smlouva;
    }

    public void setPojisteni(Set<Pojisteni> pojisteni) {
        this.pojisteni = pojisteni;
    }
}

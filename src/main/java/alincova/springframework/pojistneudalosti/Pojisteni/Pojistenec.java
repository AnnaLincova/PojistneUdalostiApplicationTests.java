package alincova.springframework.pojistneudalosti.Pojisteni;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pojistenec {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private int age;

    @OneToMany
    @JoinColumn(name = "pojistenec_id")
    private Set<Smlouva> smlouvy = new HashSet<>();

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

    public String getSmlouvyTypes() {
        StringBuilder sb = new StringBuilder();
        smlouvy.forEach(smlouva ->
        {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(smlouva.getType());
        });
        return sb.toString();
    }

    public Set<Smlouva> getSmlouvy() {
        return smlouvy;
    }

    public void setSmlouvy(Set<Smlouva> smlouvy) {
        this.smlouvy = smlouvy;
    }
}

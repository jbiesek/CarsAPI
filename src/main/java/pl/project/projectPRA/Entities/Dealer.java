package pl.project.projectPRA.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Dealer")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Dealer.class)
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String street;
    @Column
    private String city;
    @OneToOne
    @JoinColumn(name = "boss_id", referencedColumnName = "id")
    private Person person;
    @OneToMany(
            mappedBy = "dealer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Car> cars = new ArrayList<>();


    public Dealer(String name, String street, String city, Person person) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.person = person;
    }

    public Dealer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nazwa) {
        this.name = nazwa;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

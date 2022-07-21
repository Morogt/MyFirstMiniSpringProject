package mezin.danil.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "Cars")
@Entity
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "car_name")
    @NotEmpty(message = "Name should be not empty")
    @Size(max = 100, message = "The name must be no more than 100")
    private String  name;

    @Column(name = "year_of_create")
    @Min(value = 1900, message = "Year of create should be more 1900")
    @NotNull(message = "Year of create should be not empty")
    private int yearOfCreate;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person personId;

    public Car(){}

    public Car(String name, int yearOfCreate, Person personId) {
        this.name = name;
        this.yearOfCreate = yearOfCreate;
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfCreate() {
        return yearOfCreate;
    }

    public void setYearOfCreate(int yearOfCreate) {
        this.yearOfCreate = yearOfCreate;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }
}

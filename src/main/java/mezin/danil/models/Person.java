package mezin.danil.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 100, message = "Name should be more than 2 and less than 100")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Age should be not empty")
    @Min(value = 18, message = "Age should be more less 18")
    @Max(value = 120, message = "Age should be less than 120")
    private int age;

    @Column(name = "date_of_create_account")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreateAccount;

    @OneToMany(mappedBy = "personId")
    private List<Car> cars;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfCreateAccount() {
        return dateOfCreateAccount;
    }

    public void setDateOfCreateAccount(Date dateOfCreateAccount) {
        this.dateOfCreateAccount = dateOfCreateAccount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

package mezin.danil.dto;

import javax.validation.constraints.*;

public class PersonDTO {

    @NotEmpty(message = "Name should be not empty")
    @Size(min = 2, max = 100, message = "Name should be more than 2 and less than 100")
    private String name;

    @NotNull(message = "Age should be not empty")
    @Min(value = 18, message = "Age should be more less 18")
    @Max(value = 120, message = "Age should be less than 18")
    private int age;

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
}

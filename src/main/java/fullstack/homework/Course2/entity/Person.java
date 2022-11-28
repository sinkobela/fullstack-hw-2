package fullstack.homework.Course2.entity;

import fullstack.homework.Course2.enums.AgeCategory;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static fullstack.homework.Course2.enums.AgeCategory.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final AgeCategory ageCategory;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ageCategory = setAgeCategory(age);
    }

    private AgeCategory setAgeCategory(int age) {
        if (age > 0 && age <= 30)
            return YOUNG;
        else if (age > 30 && age <= 50)
            return MIDDLE;
        else return OLD;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }
}

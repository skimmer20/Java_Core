package lesson5;

import java.util.Objects;

/**
 * @author yuriismac on 12/30/20.
 * @project Java_Core_tasks
 */
public class PersonTest implements Comparable<PersonTest> {
    private int age;
    private String name;

    public PersonTest(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTest person = (PersonTest) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(PersonTest personTest) {
        int compareByName = this.name.compareTo(personTest.getName());
        if (compareByName == 0) {
            return this.age - personTest.getAge();
        } else {
            return compareByName;
        }
    }
}

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = "";


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public boolean hasAge() {
        if (this.age != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAddress() {
        if (this.address != "") {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {

        if (this.age != -1) {
            OptionalInt optInt = OptionalInt.of(this.age);
            return optInt;
        } else {
            OptionalInt optInt = OptionalInt.empty();
            return optInt;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() throws Exception {
        if (this.age != -1) {
            this.age++;
        } else {
            throw new Exception("Некорректно");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAddress(this.address).setAge(0);
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", surname: " + this.surname + ", age: " + this.age + ", address: " + this.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname, this.age, this.address);
    }

}

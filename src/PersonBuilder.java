public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст указан не верно");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не все обязательные поля указаны");
        }
        if (this.age > -1) {
            Person person = new Person(this.name, this.surname, this.age);
            if (this.address != "") {
                person.setAddress(this.address);
            }
            return person;
        } else {
            Person person = new Person(this.name, this.surname);
            if (this.address != "") {
                person.setAddress(this.address);
            }
            return person;
        }

    }
}

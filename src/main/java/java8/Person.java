package java8;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;

    private Person(PersonBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.dateOfBirth = builder.dateOfBirth;
    }

    public enum Gender {
        MALE,
        FEMALE;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public static class PersonBuilder {

        private String firstName;
        private String lastName;
        private Gender gender;
        private LocalDate dateOfBirth;

        public PersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder ofGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder bornOn(LocalDate dob) {
            this.dateOfBirth = dob;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

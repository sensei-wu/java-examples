package java8.service;

import java8.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> olderThan(List<Person> persons, int years);

    boolean isOlderThan(Person person, int age);

    boolean isOlderThanOn(Person person, int age, LocalDate on);

    Optional<Person> findOldest(List<Person> persons);
}

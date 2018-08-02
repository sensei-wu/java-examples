package java8.service;

import java8.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> olderThan(List<Person> persons, int years) {
        if(persons == null) {
            return Collections.emptyList();
        }
        if(years < 0) {
            return persons;
        }

        return persons.stream()
                .filter(p -> isOlderThan(p, years))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isOlderThan(Person person, int age) {
        return isOlderThanOn(person, age, LocalDate.now());
    }

    @Override
    public boolean isOlderThanOn(Person person, int age, LocalDate on) {
        return Period.between(person.getDateOfBirth(), on).getYears() >= age;
    }

    @Override
    public Optional<Person> findOldest(List<Person> persons) {
        return persons.stream().min(Comparator.comparing(Person::getDateOfBirth));
    }
}

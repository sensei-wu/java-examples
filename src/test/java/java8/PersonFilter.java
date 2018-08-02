package java8;

import java8.service.PersonService;
import java8.service.PersonServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;

public class PersonFilter {

    @Disabled
    @ParameterizedTest
    @MethodSource("java8.util.PersonUtil#personData")
    public void olderThan(Person person) {
        PersonService personService = new PersonServiceImpl();
        Assertions.assertTrue(personService.isOlderThanOn(person, 7, LocalDate.of(2018, Month.JULY, 29)));
    }

    @Test
    public void olderThan() {
        Person.PersonBuilder builder = new Person.PersonBuilder();

        PersonService personService = new PersonServiceImpl();

        final Person aidan = builder.withFirstName("Aidan")
                .withLastName("Götz")
                .bornOn(LocalDate.of(2011, Month.JULY, 28))
                .ofGender(Person.Gender.MALE)
                .build();

        Assertions.assertTrue(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 29)));

        Assertions.assertTrue(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 28)));

        Assertions.assertFalse(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 27)));

        Assertions.assertFalse(personService.isOlderThanOn(aidan, 6, LocalDate.of(2017, Month.JULY, 27)));
    }
}

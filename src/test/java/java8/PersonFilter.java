package java8;

import java8.service.PersonService;
import java8.service.PersonServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonFilter {

    final private List<Person> data = new ArrayList<>();

    private final PersonService personService = new PersonServiceImpl();

    @BeforeAll
    public void setUp() {

        Person.PersonBuilder builder = new Person.PersonBuilder();

        final Person aidan = builder.withFirstName("Aidan")
                .withLastName("Gunsu")
                .bornOn(LocalDate.of(2011, Month.JULY, 28))
                .ofGender(Person.Gender.MALE)
                .build();
        data.add(aidan);

        final Person zoe = builder.withFirstName("Zoe")
                .withLastName("Gunsi")
                .bornOn(LocalDate.of(2015, Month.JULY, 15))
                .ofGender(Person.Gender.FEMALE)
                .build();
        data.add(zoe);

        final Person simon = builder.withFirstName("Simon")
                .withLastName("Gilfond")
                .bornOn(LocalDate.of(2011, Month.DECEMBER, 15))
                .ofGender(Person.Gender.MALE)
                .build();
        data.add(simon);

        final Person florian = builder.withFirstName("Florian")
                .withLastName("Pliganjith")
                .bornOn(LocalDate.of(2012, Month.JANUARY, 13))
                .ofGender(Person.Gender.MALE)
                .build();
        data.add(florian);

        final Person luisa = builder.withFirstName("Luisa")
                .withLastName("Plisheena")
                .bornOn(LocalDate.of(2011, Month.JULY, 18))
                .ofGender(Person.Gender.FEMALE)
                .build();
        data.add(luisa);

        final Person vladeena = builder.withFirstName("Vladeena")
                .withLastName("Vladeena")
                .bornOn(LocalDate.of(2011, Month.JULY, 18))
                .ofGender(Person.Gender.FEMALE)
                .build();
        data.add(vladeena);
    }

    private Person findPersonByFirstName(String firstName) {
        return data.stream().filter(person -> person.getFirstName().equalsIgnoreCase(firstName)).findFirst().get();
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("java8.util.PersonUtil#personData")
    public void olderThan(Person person) {
        Assertions.assertTrue(personService.isOlderThanOn(person, 7, LocalDate.of(2018, Month.JULY, 29)));
    }

    @Test
    public void olderThan() {
        Person.PersonBuilder builder = new Person.PersonBuilder();

        final Person aidan = findPersonByFirstName("Aidan");

        Assertions.assertTrue(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 29)));

        Assertions.assertTrue(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 28)));

        Assertions.assertFalse(personService.isOlderThanOn(aidan, 7, LocalDate.of(2018, Month.JULY, 27)));

        Assertions.assertFalse(personService.isOlderThanOn(aidan, 6, LocalDate.of(2017, Month.JULY, 27)));
    }

    @Test
    public void oldest() {

        final Optional<Person> oldest = personService.findOldest(data);

        Assertions.assertTrue(findPersonByFirstName("luisa").equals(oldest.get()));
    }

    @Test
    public void kidsOf2011() {
        Assertions.assertEquals("Aidan,Simon,Luisa,Vladeena",
                data.stream()
                        .filter(person -> person.getDateOfBirth().getYear() == 2011)
                        .map(Person::getFirstName)
                        .collect(joining(",")));
    }
}

package java8.util;


import java8.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java8.Person.Gender;
import static java8.Person.PersonBuilder;

public class PersonUtil {

    public static List<Person> personData() {
        List<Person> data = new ArrayList<>();
        PersonBuilder builder = new PersonBuilder();

        final Person aidan = builder.withFirstName("Aidan")
                .withLastName("Gunsu")
                .bornOn(LocalDate.of(2011, Month.JULY, 28))
                .ofGender(Gender.MALE)
                .build();
        data.add(aidan);

        final Person zoe = builder.withFirstName("Zoe")
                .withLastName("Gunsi")
                .bornOn(LocalDate.of(2015, Month.JULY, 15))
                .ofGender(Gender.FEMALE)
                .build();
        data.add(zoe);

        final Person simon = builder.withFirstName("Simon")
                .withLastName("Gilfond")
                .bornOn(LocalDate.of(2011, Month.DECEMBER, 15))
                .ofGender(Gender.MALE)
                .build();
        data.add(simon);

        final Person florian = builder.withFirstName("Florian")
                .withLastName("Pliganjith")
                .bornOn(LocalDate.of(2011, Month.NOVEMBER, 13))
                .ofGender(Gender.MALE)
                .build();
        data.add(florian);

        final Person luisa = builder.withFirstName("Luisa")
                .withLastName("Plisheena")
                .bornOn(LocalDate.of(2011, Month.JULY, 18))
                .ofGender(Gender.FEMALE)
                .build();
        data.add(luisa);

        return data;

    }
}

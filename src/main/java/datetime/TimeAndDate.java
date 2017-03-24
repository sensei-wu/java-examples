package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Understanding JAVA 8 Date and Time API
 */
public class TimeAndDate {

    public static void main(String[] args) {

        //Instant represents an instantaneous point in time, based on Java epoch
        Instant now = Instant.now();
        System.out.println("#seconds since Epoch in milliseconds" + ": " + now.toEpochMilli());

        long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(),
                ChronoUnit.SECONDS);
        System.out.println("#seconds since Epoch in seconds" + ": " + secondsFromEpoch);

        //LocalDateTime is a date & time model without a timezone -- ideal to store timezone independent models like birthday
        LocalDateTime dob = LocalDateTime.of(1978, Month.MARCH, 11, 21, 10, 10);

        //
        long secondsSinceIwasBorn = Duration.between(dob.toInstant(ZoneOffset.ofHoursMinutes(5, 30)), Instant.now()).getSeconds();

        System.out.println("secondsSinceIwasBorn" + ": " + secondsSinceIwasBorn);

        System.out.println("minutesSinceIwasBorn" + ": " + secondsSinceIwasBorn / 60);

        System.out.println("hoursSinceIwasBorn" + ": " + secondsSinceIwasBorn / (60 * 60));

        System.out.println("daysSinceIwasBorn" + ": " + secondsSinceIwasBorn / (60 * 60 * 24));

        System.out.println("-------------------------------------------------------------------");

        Period period = Period.between(dob.toLocalDate(), LocalDate.now());

        System.out.println(String.format("I am now %d years, %d months and %d days old",
                period.getYears(), period.getMonths(), period.getDays()));

        long numberOfDaysSinceBirth = ChronoUnit.DAYS.between(dob.toLocalDate(), LocalDate.now());
        System.out.println(String.format("%d days have passed since I was born", numberOfDaysSinceBirth));
    }
}
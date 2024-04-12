package csv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Person {
    String name;
    LocalDate birthDate;
    LocalDate deathDate;
    List<Person> parents;

    public Person(String name, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    };

    public static Person fromCsvLine(String csvLine) {
        String[] stringArray = csvLine.split(",", -1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        LocalDate birthDate = LocalDate.parse(stringArray[1], formatter);
        LocalDate deathDate = stringArray[2].equals("") ? null : LocalDate.parse(stringArray[2], formatter);
        return new Person(stringArray[0], birthDate, deathDate);
    }
}

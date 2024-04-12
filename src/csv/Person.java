package csv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public LocalDate birthDate;
    public LocalDate deathDate;
    List<Person> parents;

    public Person(String name, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
    };

    public static Person fromCsvLine(String csvLine) {
        String[] line = csvLine.split(",", -1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(line[1], formatter);
        LocalDate deathDate = line[2].equals("") ? null : LocalDate.parse(line[2], formatter);
        return new Person(line[0], birthDate, deathDate);
    }

    public static List<Person> fromCsv(String path) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String linia = "";
        List<Person> personList = new ArrayList<>();
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            while ((linia = bufferedReader.readLine()) != null) {
                Person person = fromCsvLine(linia);
                person.validateLifeSpan();
                personList.add(person);
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NegativeLifespanException e) {
            System.err.println(e.getMessage());
        }
        return personList;
    }

    public void validateLifeSpan() throws NegativeLifespanException{
        if (deathDate != null && deathDate.isBefore(birthDate)){
            throw new NegativeLifespanException(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", parents=" + parents +
                '}';
    }
}

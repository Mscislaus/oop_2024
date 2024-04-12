package csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        this.parents = new ArrayList<>();
    }
    public static Person fromCsvLine(String csvLine){
        String[] personList=csvLine.split(",",-1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(personList[1],formatter);
        LocalDate deathDate =personList[2].equals("") ? null : LocalDate.parse(personList[2],formatter);
        return new Person(personList[0],birthDate,deathDate);
    }
    public static List<Person> fromCsv(String path){
        FileReader file = null;
        BufferedReader buffered = null;
        String linia = "";
        List<Person> personList= new ArrayList<>();
        try {
            file = new FileReader(path);
            buffered = new BufferedReader(file);
            buffered.readLine();
            while((linia = buffered.readLine()) != null){
                Person person = fromCsvLine(linia);
                personList.add(person);
            }
            if (buffered != null) buffered.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList;
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


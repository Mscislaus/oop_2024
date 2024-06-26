package csv;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Person.fromCsv("family.csv");
//        for(Person person: people)
//            System.out.println(person);
//
//        try {
//            Person.toBinaryFile(people, "family.bin");
//            List<Person> loadPeople = Person.fromBinaryFile("family.bin");
//            for(Person person: loadPeople)
//                System.out.println(person);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(people.get(3).generateTree());
        System.out.println(Person.generateTree(people));

        PlantUMLRunner.setPlantUMLPath("C:\\Users\\Legion\\IdeaProjects\\Programowanie_Obiektowe\\plantuml-1.2024.4.jar");
        PlantUMLRunner.GenerateDiagram(Person.generateTree(people), "./", "Parse");
    }
}
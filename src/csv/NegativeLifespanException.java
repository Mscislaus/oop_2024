package csv;

public class NegativeLifespanException extends Exception {
    public NegativeLifespanException(Person person) {
        super("Person: " + person.name + " born in: " + person.birthDate + " died in: " + person.deathDate +
                ". Died before Birthdate!!!");
    }
}

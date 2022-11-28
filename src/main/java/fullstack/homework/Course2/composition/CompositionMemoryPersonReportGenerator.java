package fullstack.homework.Course2.composition;

import fullstack.homework.Course2.entity.Person;

import java.util.List;

public class CompositionMemoryPersonReportGenerator implements CompositionPersonReportReader {

    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("John", "Doe", 11),
                new Person("Mark", "Akiltam", 33),
                new Person("Johny", "Sins", 69),
                new Person("Futy", "Imre", 22),
                new Person("Veg", "Bela", 44),
                new Person("Hufnagel", "Pisti", 66)
        );
    }
}

package fullstack.homework.Course2.inheritance;

import fullstack.homework.Course2.entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static fullstack.homework.Course2.utility.PersonUtility.getAgeNameMap;
import static java.lang.String.join;

abstract class InheritancePersonReportGenerator {

    private static final String COMMA = ", ";
    private static final String COLON = ": ";

    public void generateReport(String file) throws IOException {
        List<Person> persons = readPersons();
        writeReport(persons, file);
    }

    public void writeReport(List<Person> persons, String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            getAgeNameMap(persons).forEach((k, v) ->
                    writeLine(writer, k + COLON + join(COMMA, v)));
        }
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    abstract List<Person> readPersons();
}

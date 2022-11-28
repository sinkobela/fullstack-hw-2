package fullstack.homework.Course2.composition;

import fullstack.homework.Course2.entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static fullstack.homework.Course2.utility.PersonUtility.getAgeNameMap;
import static java.lang.String.join;

public class CompositionPersonReportGenerator {

    private static final String COMMA = ", ";
    private static final String COLON = ": ";
    private final CompositionPersonReportReader reportReader;

    public CompositionPersonReportGenerator(CompositionPersonReportReader reportReader) {
        this.reportReader = reportReader;
    }

    public void generateReport(String file) throws IOException {
        List<Person> persons = reportReader.readPersons();
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
}

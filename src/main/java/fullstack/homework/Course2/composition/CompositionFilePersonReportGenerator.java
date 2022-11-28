package fullstack.homework.Course2.composition;

import fullstack.homework.Course2.entity.Person;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;

public class CompositionFilePersonReportGenerator implements CompositionPersonReportReader {

    private static final String CANNOT_READ_FILE_MESSAGE = "Cannot read from this file: %s";
    private static final String COMMA = ",";
    private final String filePath;

    public CompositionFilePersonReportGenerator(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Person> readPersons() {
        try (Stream<String> lines = lines(Path.of(filePath))) {
            return lines.map(this::readPerson)
                    .collect(toList());
        } catch (IOException e) {
            throw new RuntimeException(format(CANNOT_READ_FILE_MESSAGE, filePath));
        }
    }

    private Person readPerson(String fileLine) {
        List<String> line = List.of(fileLine.split(COMMA));
        return new Person(line.get(0), line.get(1), parseInt(line.get(2)));
    }
}

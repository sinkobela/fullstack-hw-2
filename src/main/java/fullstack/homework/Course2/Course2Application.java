package fullstack.homework.Course2;

import fullstack.homework.Course2.composition.CompositionFilePersonReportGenerator;
import fullstack.homework.Course2.composition.CompositionMemoryPersonReportGenerator;
import fullstack.homework.Course2.composition.CompositionPersonReportGenerator;
import fullstack.homework.Course2.inheritance.InheritanceFilePersonReportGenerator;
import fullstack.homework.Course2.inheritance.InheritanceMemoryPersonReportGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Course2Application {

    private static final String FILE_PATH = "src/main/resources/people.txt";
    private static final String FILE_RESULT_PATH_INHERITANCE = "src/main/resources/inheritance-file-result.txt";
    private static final String FILE_RESULT_PATH_COMPOSITION = "src/main/resources/composition-file-result.txt";
    private static final String MEMORY_RESULT_PATH_INHERITANCE = "src/main/resources/inheritance-memory-result.txt";
    private static final String MEMORY_RESULT_PATH_COMPOSITION = "src/main/resources/composition-memory-result.txt";

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Course2Application.class, args);
        generateFilePersonReportWithInheritance();
        generateInMemoryPersonReportWithInheritance();
        generateFilePersonReportWithComposition();
        generateInMemoryPersonReportWithComposition();
    }

    private static void generateFilePersonReportWithInheritance() throws IOException {
        InheritanceFilePersonReportGenerator generator = new InheritanceFilePersonReportGenerator(FILE_PATH);
        generator.generateReport(FILE_RESULT_PATH_INHERITANCE);
    }

    private static void generateInMemoryPersonReportWithInheritance() throws IOException {
        InheritanceMemoryPersonReportGenerator generator = new InheritanceMemoryPersonReportGenerator();
        generator.generateReport(MEMORY_RESULT_PATH_INHERITANCE);
    }

    private static void generateFilePersonReportWithComposition() throws IOException {
        CompositionFilePersonReportGenerator filePersonReportGenerator = new CompositionFilePersonReportGenerator(FILE_PATH);
        CompositionPersonReportGenerator personReportGenerator = new CompositionPersonReportGenerator(filePersonReportGenerator);

        personReportGenerator.generateReport(FILE_RESULT_PATH_COMPOSITION);
    }

    private static void generateInMemoryPersonReportWithComposition() throws IOException {
        CompositionMemoryPersonReportGenerator memoryPersonReportGenerator = new CompositionMemoryPersonReportGenerator();
        CompositionPersonReportGenerator personReportGenerator = new CompositionPersonReportGenerator(memoryPersonReportGenerator);

        personReportGenerator.generateReport(MEMORY_RESULT_PATH_COMPOSITION);
    }
}

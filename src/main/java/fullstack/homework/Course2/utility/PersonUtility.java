package fullstack.homework.Course2.utility;

import fullstack.homework.Course2.entity.Person;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.List.of;

@UtilityClass
public class PersonUtility {

    public static Map<String, List<String>> getAgeNameMap(List<Person> persons) {
        Map<String, List<String>> map = new TreeMap<>();
        persons.forEach(person -> {
            if (map.containsKey(person.getAgeCategory().getAgeCategory()))
                map.get(person.getAgeCategory().getAgeCategory()).add(person.getFullName());
            else map.put(person.getAgeCategory().getAgeCategory(), new ArrayList<>(of(person.getFullName())));
        });
        return map;
    }
}

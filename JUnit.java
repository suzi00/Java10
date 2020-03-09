import org.junit.Test;

import fmi.informatics.extending.Student;
import fmi.informatics.functional.Rock;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

public class JUnit {

    @Test
    public void testTask1() {
        ArrayList<Student> studs = new ArrayList<Student>();
        Stream.of(Student.StudentGenerator.make(),
                Student.StudentGenerator.make(),
                Student.StudentGenerator.make()
        )
                .filter(s -> s.getName().length() > 4)
                .sorted((s1, s2) -> s2.getName().compareTo(s1.getName()))
                .forEach(s -> studs.add(s));

        Assert.assertEquals(studs.get(0).getName().toString(),"Lily");
    }

    @Test
    public void testTask2() {
        ArrayList<String> pets = new ArrayList<String>();
        Stream.of("dog", "cat", "donkey","monkey")
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList())
                .forEach(s -> pets.add(s));


        Assert.assertEquals(pets.get(0),"cat");
    }

    @Test
    public void testTask3() {
        List<Student> studs = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            ((ArrayList) studs).add(Student.StudentGenerator.make());
        }
        String studNames = studs.stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .map(s -> s.getName())
                .reduce((s1, s2) -> {
                    if (s2 != null) return s1 + ", " + s2;
                    return s1;
                })
                .get();
        System.out.println(studNames);


        Assert.assertEquals(studNames,"Ivan, Petya, Stoyan, Ivan, Lily");
    }

    @Test
    public void testTask5() {
        Rock onEarth = new Rock();
        onEarth.drop(onEarth.height());
        Rock onVenus = new Rock();

        assertEquals(onEarth,onVenus);

    }

}

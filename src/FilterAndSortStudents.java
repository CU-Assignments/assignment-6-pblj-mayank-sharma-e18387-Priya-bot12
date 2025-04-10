import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double percentage;

    public Student(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() { return name; }
    public double getPercentage() { return percentage; }

    @Override
    public String toString() {
        return name + " (" + percentage + "%)";
    }
}

public class FilterAndSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("John", 85.0),
            new Student("Emma", 70.5),
            new Student("Amit", 92.3),
            new Student("Sara", 76.8)
        );

        System.out.println("Students scoring above 75%:");
        students.stream()
                .filter(s -> s.getPercentage() > 75)
                .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}

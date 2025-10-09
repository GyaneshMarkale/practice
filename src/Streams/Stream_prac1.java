package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream_prac1 {
    public static void main(String args[]) {
        List<Student> students = Arrays.asList(
                new Student(1, "aaa", Arrays.asList(
                        new Subject(1, "Maths", 70),
                        new Subject(2, "English", 88))),
                new Student(2, "bbb", Arrays.asList(
                        new Subject(1, "Maths", 90),
                        new Subject(2, "English", 65))),
                new Student(3, "ccc", Arrays.asList(
                        new Subject(1, "Maths", 100),
                        new Subject(2, "English", 95))),
                new Student(4, "ddd", Arrays.asList(
                        new Subject(1, "Maths", 55),
                        new Subject(2, "English", 67))),
                new Student(5, "eee", Arrays.asList(
                        new Subject(1, "Maths", 45),
                        new Subject(2, "English", 100)))

        );
        List<Student> topThree = students.stream().
                sorted(Comparator.comparingDouble(Student::getAverage).
                        reversed()).limit(3).toList();
        topThree.forEach(s -> System.out.println(s.getName() + " with average marks: " + s.getAverage()));
        int minMarks = students.stream().map(Student::getMinMarks).min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("minMarks: " + minMarks);
//        students.stream().map(Streams.Student::getMinMarks).map(Streams.Student::getId).forEach( -> System.out.println(s +" " +s));
////        mini.forEach(x -> System.out.println(x));
////        System.out.println(mini);
    }
}
class Student {
    int id;
    String name;
    List<Subject> subjects;

    Student(int _id, String _name, List<Subject> _subjects) {
        this.id = _id;
        this.name = _name;
        this.subjects = _subjects;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverage(){
        return subjects.stream().mapToInt(Subject::getMarks).average().orElse(0.0);
    }

    public int getMinMarks()
    {
        return subjects.stream().map(Subject::getMarks).min(Comparator.comparing(Integer::valueOf)).get();
    }
}

class Subject {
    int id;
    String name;
    int marks;

    Subject(int _id, String _name, int _marks)
    {
        this.id = _id;
        this.name = _name;
        this.marks = _marks;
    }

    public int getMarks()
    {
        return marks;
    }
}

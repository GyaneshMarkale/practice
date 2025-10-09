package DesignPatterns.AdapterPattern;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        StudentClient studentClient = new StudentClient();
        List<Student> students = studentClient.getStudentList();
        System.out.println(students);
    }
}

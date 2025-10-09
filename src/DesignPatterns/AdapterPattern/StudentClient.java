package DesignPatterns.AdapterPattern;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {
    public List<Student> getStudentList() {
        List<Student> list = new ArrayList<>();
        CollegeStudent collegeStudent = new CollegeStudent("Vikram", "Batra", "xyz");
        SchoolStudent schoolStudent = new SchoolStudent("Rohan", "Batra", "xyz");
        list.add(collegeStudent);
        list.add(new SchoolStudentAdapter(schoolStudent));
        return list;
    }

}

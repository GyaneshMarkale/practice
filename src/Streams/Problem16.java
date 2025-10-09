package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class Problem16 {
    public static void main(String[] args)
    {
        List<Employee> employeesList = new ArrayList<>();
        Employee emp1 = new Employee("Gyanesh", "SDE", 25);
        Employee emp2 = new Employee("Sehaj", "SDE", 50);
        Employee emp3 = new Employee("Raj", "HR", 25);
        Employee emp4 = new Employee("Sham", "HR", 20);
        employeesList.add(emp1);
        employeesList.add(emp2);
        employeesList.add(emp3);
        employeesList.add(emp4);

        Map<String, Double> avgSalaryPerDept = employeesList.stream().
                collect(Collectors.groupingBy(ele -> ele.department, Collectors.averagingDouble(ele -> ele.salary)));
        Map<String, Double> totalSalaryPerDept = employeesList.stream().
                collect(Collectors.groupingBy(ele -> ele.department, Collectors.summingDouble(ele -> ele.salary)));
        System.out.println(avgSalaryPerDept);
        System.out.println(totalSalaryPerDept);


    }
}

class Employee {
    String name;
    String department;
    double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

package DesignPatterns.AbstractDesignPattern;

import java.lang.foreign.SegmentAllocator;

public class DeveloperClient {
    public static void main(String[] args)
    {
        Employee emp1 = EmployeeFactory.getEmployee(new AndroidDevFactory());
        System.out.println(emp1.getName());
        System.out.println("Salary: "+ emp1.getSalary());

        Employee emp2 = EmployeeFactory.getEmployee(new WebDevFactory());
        System.out.println(emp2.getName());
        System.out.println("Salary: "+ emp2.getSalary());

    }
}

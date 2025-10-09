package DesignPatterns.FactoryPattern;

public class DeveloperClient {
    public static void main(String[] args)
    {
        Employee emp1 = EmployeeFactory.getEmployee("ANDROID DEVELOPER");
        System.out.println("Salary: "+emp1.getSalary());
        Employee emp2 = EmployeeFactory.getEmployee("web developer");
        System.out.println("Salary: "+ emp2.getSalary());

    }
}

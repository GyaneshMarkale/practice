package DesignPatterns.FactoryPattern;

public class WebDeveloper implements Employee{
    @Override
    public int getSalary() {
        System.out.println("This is Web Developer");
        return 40000;
    }
}

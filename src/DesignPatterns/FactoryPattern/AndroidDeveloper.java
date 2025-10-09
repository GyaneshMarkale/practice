package DesignPatterns.FactoryPattern;

public class AndroidDeveloper implements Employee{
    @Override
    public int getSalary() {
        System.out.println("This is Android developer");
        return 50000;
    }
}

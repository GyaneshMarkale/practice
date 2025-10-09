package DesignPatterns.AbstractDesignPattern;

public class WebDeveloper implements Employee{
    @Override
    public int getSalary() {
        return 40000;
    }

    public String getName()
    {
        return "I am Web Developer";
    }
}

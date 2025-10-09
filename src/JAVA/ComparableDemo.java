package JAVA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
    int id;
    String name;

    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;
    }
}
public class ComparableDemo {
    public static void main(String[] args)
    {
        Employee emp1 = new Employee(2, "Alice");
        Employee emp2 = new Employee(1, "Sam");
        List<Employee> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        Collections.sort(list);
        list.stream().forEach(e -> System.out.println(e.id));
    }
}

package HashCodeAndEqualContract;

import DesignPatterns.FactoryPattern.EmployeeFactory;
import com.sun.source.tree.EmptyStatementTree;

import java.util.*;

class Employee {
    private int id;
    private String name;

    Employee (int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Employee employee = (Employee) obj;
//        return id == employee.id && Objects.equals(name, employee.name);
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class Main{
    public static void main(String[] args)
    {
        Map<Employee, Integer> map= new HashMap<>();
        map.put(new Employee( 1, "A"), 0);
        map.put(new Employee(1, "A"), 1);
        map.put(new Employee(1, "B"), 1);
        map.put(new Employee(2, "C"),2);

        System.out.println(map.size());

        Set<Employee> set = new HashSet<>();
        set.add(new Employee(1, "A"));
        set.add(new Employee(1, "A"));
        System.out.println(set.size());


    }
}

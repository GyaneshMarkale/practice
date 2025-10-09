package Streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * List<Employee> employeeList = new ArrayList<Employee>();
 * employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
 * employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
 * employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
 * employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
 * employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
 */
public class EmployeeDemo {
    public static void main(String[] args)
    {
        List<Employee1> employeeList = new ArrayList<>();
        employeeList.add(new Employee1(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee1(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee1(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee1(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee1(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee1(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee1(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee1(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee1(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee1(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee1(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee1(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee1(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee1(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee1(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee1(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee1(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//       Optional<Employee1> sHSalary = employeeList.stream().sorted(Comparator.comparingDouble(Employee1::getSalary).reversed()).distinct().skip(1).findFirst();
//        employeeList.stream().collect(Collectors.groupingBy(employee1 -> employee1.department, Collectors.averagingDouble(Employee1::getSalary)));


//        Optional<Employee1> secondHighestSalaryDetails = employeeList.stream()
//                        .sorted(Comparator.comparingDouble(Employee1::getSalary).reversed())
//                .distinct().skip(1).findFirst();
//        System.out.println(secondHighestSalaryDetails);
//        Map<String, Double> collect = employeeList.stream()
//                .collect(Collectors.groupingBy(emp -> emp.department,Collectors.averagingDouble(Employee1::getSalary)));
//        System.out.println(collect);


//

        List<Employee1> list = employeeList.stream().sorted(Comparator.comparing(Employee1::getDepartment)
                .thenComparing(Employee1::getSalary).reversed()).collect(Collectors.toList());
        System.out.println(list);

        Map<String, Double> collect = list.stream()
                .collect(Collectors.groupingBy(Employee1::getDepartment, Collectors
                        .averagingDouble(Employee1::getSalary)));
        System.out.println(collect);
    }
}

class Employee1 {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee1(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : " + department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
    }
}

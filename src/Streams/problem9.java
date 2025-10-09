package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Author {
    private String Fname;
    private String surname;
    private int age;

    public Author(String fname, String surname, int age) {
        Fname = fname;
        this.surname = surname;
        this.age = age;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "Fname='" + Fname + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
public class problem9 {
    public static void main (String[] agrs)
    {
        List<Author> list = new ArrayList<>();
        list.add(new Author("Mahesh", "Sharma", 51));
        list.add(new Author("Ramesh", "Patel", 40));
        list.add(new Author("Ankit", "Patel", 60));
        list.add(new Author("Suresh", "Sharma", 53));
        list.add(new Author("Rohan", "Patel", 61));

        List<String> res =
                list.stream().filter(author -> author.getAge() > 50)
                        .map(author -> author.getSurname().toUpperCase())
                        .collect(Collectors.toList());
        System.out.println(res);

    }
}

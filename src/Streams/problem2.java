package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class problem2 {
    public static void main(String[] args) {
        //Get the Longest String
        List<String> res1 = new ArrayList<>(Arrays.asList("GFG", "Rahul", "Image", "Employee", "EmployeeDocuments"));


        String s = res1.stream().max(Comparator.comparing(String::length)).get();
//        String out = res1.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(s);
    }
}

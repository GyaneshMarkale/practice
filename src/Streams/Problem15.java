package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem15 {
    public static void main(String[] args)
    {
        List<User> list = new ArrayList<>();
        User user1 = new User("Gyanesh", 31, Arrays.asList("ADMIN", "NORMAL"));
        User user2 = new User("Sehaj", 30, Arrays.asList("ADMIN"));
        User user3 = new User("Raj", 22, Arrays.asList("NORMAL"));
        list.add(user1);
        list.add(user2);
        list.add(user3);

        list.stream().filter(u -> u.age > 25 && u.roles.contains("ADMIN")).map(user -> user.name).sorted().forEach(System.out::println);


//        List<String> adminUser = list.stream().filter(user -> user.age > 25 && user.roles.contains("ADMIN"))
//                .map(user -> user.name)
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(adminUser);


    }
}

class User {
    String name;
    int age;
    List<String> roles = new ArrayList<>();

    public User(String name, int age, List<String> roles) {
        this.name = name;
        this.age = age;
        this.roles = roles;
    }
}


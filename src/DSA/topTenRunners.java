package DSA;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Runner {
    private int id;
    private String runner;
    private double time; // time to complete 10 miles

    public Runner(int id, String runner, double time) {
        this.id = id;
        this.runner = runner;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRunner() {
        return runner;
    }

    public void setRunner(String runner) {
        this.runner = runner;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", runner='" + runner + '\'' +
                ", time=" + time +
                '}';
    }
}
public class topTenRunners {
    // implement a solution to generate a leaderboard for the top 10 runners at the 10-mile mark of a 26.2-mile race

    public static void main(String[] args)
    {
        List<Runner> runners = Arrays.asList(
                new Runner(1, "Alice", 62.5),
                new Runner(2, "Bob", 58.3),
                new Runner(3, "Charlie", 65.0),
                new Runner(4, "David", 60.2),
                new Runner(5, "Eve", 55.1),
                new Runner(6, "Frank", 70.0),
                new Runner(7, "Grace", 59.9),
                new Runner(8, "Henry", 61.0),
                new Runner(9, "Ivy", 64.3),
                new Runner(10, "Jack", 63.7),
                new Runner(11, "Karen", 54.8),
                new Runner(12, "Leo", 57.5)
        );


       Map<String, Double> map = runners.stream().sorted(Comparator.comparingDouble(runner -> runner.getTime())).limit(10)
               .collect(Collectors.toMap(Runner::getRunner, Runner::getTime,  (existing, replacement) -> existing, LinkedHashMap::new));
       System.out.println(map);


    }
}

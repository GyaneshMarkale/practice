package DesignPatterns.StratedyPattern;

public class Main {
    public static void main(String[] args)
    {
        Vehicle vehicle = new OffRoad(new SpecialDrive());
        Vehicle vehicle1 = new Normal(new NormalDrive());
        Vehicle vehicle2 = new Sporty(new SpecialDrive());  // same functionality as off road
        vehicle.drive();
        vehicle1.drive();
        vehicle2.drive();

    }
}

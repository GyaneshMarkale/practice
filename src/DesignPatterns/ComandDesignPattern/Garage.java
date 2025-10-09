package DesignPatterns.ComandDesignPattern;

public class Garage {
    public Garage() {
    }

    public void On() {
        System.out.println("Light on");
    }

    public void Off() {
        System.out.println("Light off");
    }
    public void up() {
        System.out.println("Door open");
    }

    public void Down() {
        System.out.println("Door close");
    }
    public void stop() {
        System.out.println("stop");
    }
}

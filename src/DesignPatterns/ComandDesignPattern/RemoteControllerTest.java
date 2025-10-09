package DesignPatterns.ComandDesignPattern;

public class RemoteControllerTest {
    public static void main(String [] args)
    {
        SimpleRemoteController remote = new SimpleRemoteController();

        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOn);
        
        remote.buttonPressed();
    }
}

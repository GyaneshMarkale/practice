package DesignPatterns.ComandDesignPattern;

public class SimpleRemoteController {
    Command slot;

    public SimpleRemoteController(){
    }

    public void setCommand(Command command)
    {
        slot = command;
    }
    public void buttonPressed()
    {
        slot.execute();
    }
}

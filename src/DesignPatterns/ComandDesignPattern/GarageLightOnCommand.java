package DesignPatterns.ComandDesignPattern;

public class GarageLightOnCommand implements Command{
    Garage garage;

    public GarageLightOnCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.On();
    }
}

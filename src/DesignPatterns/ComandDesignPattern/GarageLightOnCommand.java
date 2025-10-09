package DesignPatterns.ComandDesignPattern;

public class GarageCommand implements Command{
    Garage garage;

    public GarageCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        garage.On();
    }
}

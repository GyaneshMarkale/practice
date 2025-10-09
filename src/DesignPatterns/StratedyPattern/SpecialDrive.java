package DesignPatterns.StratedyPattern;

public class SpecialDrive implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println( "this is special drive");
    }
}

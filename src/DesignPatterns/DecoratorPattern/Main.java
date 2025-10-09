package DesignPatterns.DecoratorPattern;

public class Main {
    public static void main(String[] args)
    {
        BasePizza pizza1 = new ExtraCheese(new Farmhouse());
        System.out.println(pizza1.cost());

        BasePizza pizza2 = new Margherita();
        System.out.println("Just Margherita: "+pizza2.cost());

        BasePizza pizza3 = new ExtraCheese(new Margherita());
        System.out.println("Margherita with extra cheese: "+pizza3.cost());
    }
}

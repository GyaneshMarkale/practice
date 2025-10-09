package DesignPatterns.DecoratorPattern;

public class ExtraCheese extends Toppings{
    BasePizza basePizza;   // has-a relationship with BasePizza

    public ExtraCheese(BasePizza pizza)
    {
        this.basePizza = pizza;
    }
    @Override
    public int cost()
    {
        return basePizza.cost() + 10;
    }
}

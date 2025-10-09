package AbastractTest;

import java.util.SortedMap;

abstract class Animal {
    String name;

    Animal(String _name)
    {
        this.name = _name;
    }

    //concrete method;
    void eat()
    {
        System.out.println(name +" eating.");
    }

    // abstract method
    abstract void sound();
}

class Dog extends Animal {
    Dog (String name)
    {
        super(name);
    }
    @Override
    void sound() {
        System.out.println("barks");
    }
}

package JAVA.Inheritance;

import javax.smartcardio.ATR;

class Animal {
    private String sound;
    private int limbs;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }
}

class Dog extends Animal {
    public String getSound()
    {
        System.out.println("bark");
        return null;
    }
}

class Lion extends Animal {
    public String getSound()
    {
        System.out.println("Roar");
        return null;
    }
}

public class MainClass {
    public static void main(String[] args)
    {
        Animal a = new Dog();
        String sound = a.getSound();
        System.out.println(sound);
    }
}

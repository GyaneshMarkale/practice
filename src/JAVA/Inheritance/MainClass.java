package JAVA.Inheritance;

public class Animal {
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

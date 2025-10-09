package DesignPatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonClass {
    public static void main (String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
        c.setAccessible(true);
        Singleton s3 = c.newInstance();
    }
}

class Singleton{
    private static Singleton singleton;
    private Singleton(){
        //
    }

    public static Singleton getInstance()
    {
        if (null == singleton) {
            singleton = new Singleton();
        }
        else {
            throw new RuntimeException("Singleton object already created !!!!");
        }
        return singleton;
    }
}

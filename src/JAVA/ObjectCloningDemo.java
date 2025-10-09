package JAVA;

class Address implements Cloneable {
    String city;
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
}
class Person implements Cloneable {
    String name;
    Address address;
    public Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.address = (Address) address.clone(); // deep clone
        return person;
    }
}
public class ObjectCloningDemo {
    public static void main(String[] agrs)
    {
        Person person = new Person();
        person.name = "Gyanesh";
        Address address = new Address();
        address.city = "Hyderbad";
        person.address = address;

        System.out.println(person);
    }
}

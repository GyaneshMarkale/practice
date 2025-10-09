public class RecordDemo {
    public static void main(String[] agrs)
    {
        Alien a1 = new Alien(1, "xyz");
        Alien a2 = new Alien(0, "xyz");

        System.out.println(a1.equals(a2));
        System.out.println(a1);
    }
}

record Alien(int id, String name) {
    public Alien{
        if (id == 0)
        {
            throw new IllegalStateException("Cannot be zero");
        }
    }
}

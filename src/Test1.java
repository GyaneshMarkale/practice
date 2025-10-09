import java.util.HashSet;
import java.util.Set;

public class Test1 {
    private String name;
    private int id;

    public Test1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args)
    {
        Test1 t1 = new Test1("RAM", 1);
        Test1 t2 = new Test1("RAM", 1);
        Set<Test1> set = new HashSet<>();
        set.add(t1);
        set.add(t2);
        System.out.println(set.size());
    }
}

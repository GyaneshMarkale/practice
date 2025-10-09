import java.util.ArrayList;
import java.util.List;

public class expQues {
    public static void main(String[] args)
    {
        List<String> list1 = new ArrayList<>();
            list1.add("A");
            list1.add("B");
            list1.add("C");

        List<String> list2 = list1;
            list2.add("D");

        modifyList(list1);

            System.out.println("List 1: " + list1);
            System.out.println("List 2: " + list2);
    }

    public static void modifyList(List<String> list) {
        list = new ArrayList<>();
        list.add("X");
        list.add("Y");
    }
}

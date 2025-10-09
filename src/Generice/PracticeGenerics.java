package Generice;

import java.util.ArrayList;

public class PracticeGenerics {
    //Without generics

    public static void main(String[] agrs)
    {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Hello String");
        arrayList.add(123);
        arrayList.add(3.14);

        Object o = arrayList.get(0);
        String str = (String) arrayList.get(0); // need Object so need to type cast to String
        System.out.println("Object: "+o);
        System.out.println("String: "+ str);

       // String integer = (String) arrayList.get(1); // IDE wont give error,but at runtime exception occurs(class castException)

        System.out.println(arrayList);

        //Generics
        ArrayList<String> al = new ArrayList<>();
        al.add("Hello String");
        System.out.println(al);
        //al.add(123);  // this will not be allowed

//        Box box = new Box();
//        box.setValue(1);
//        //String i = box.getValue();  // Exception
//        String i = (String) box.getValue();  // RunTime exception (ClassCastException)
//        System.out.println("box object value: "+i);

        Box<Integer> box = new Box<>();
        box.setValue(1);
        //box.setValue("helll");  //no allowed. Its a Integer type
        System.out.println("value: "+box.getValue());

        // Box with bound type parameter
//        Box<String> box2 = new Box<>();
//        box2.setValue("Hello");
//        System.out.println(box2.getValue());

        Pair<String, Integer> p = new Pair<>("Hello", 101);
        System.out.println("Key: "+p.getKey());
        System.out.println("Value: "+p.getValue());

    }
}

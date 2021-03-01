package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Double> list3 = new ArrayList<>();


        list.add("AAA");
        list.add("BB");
        list.add("CCC");
        list.add("AAA");

        //list.remove("CCC");

        System.out.println("Size: " + list.size());

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            System.out.println(list.get(i));
        }

        System.out.println("--------------------");

        for (String str: list) {
            System.out.println(str);
        }

        System.out.println("--------------------");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            String cur = (String) it.next();
            cur +="|";
            System.out.println(cur);
        }

        System.out.println("--------------------");

        for (String str: list) {
            System.out.println(str);
        }
    }
}

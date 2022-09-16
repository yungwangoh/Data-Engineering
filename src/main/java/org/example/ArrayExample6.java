package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayExample6 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);

        System.out.println(arrayList);

        List<Integer> list = arrayList.subList(2, 4);
        System.out.println(list);

        list.add(1, 9);
        System.out.println(list);
        System.out.println(arrayList);
    }
}

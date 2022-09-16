package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayExample4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Iterator<Integer> iterator = arrayList.iterator();
        ListIterator<Integer> listIterator = arrayList.listIterator(0);

        while (listIterator.hasNext()) {
            System.out.println("listIterator = " + listIterator.next());
        }

        ListIterator<Integer> listIterator1 = arrayList.listIterator(arrayList.size());
        while (listIterator1.hasPrevious()) {
            System.out.println("listIterator1 = " + listIterator1.previous());
        }
        System.out.println(arrayList);
    }
}

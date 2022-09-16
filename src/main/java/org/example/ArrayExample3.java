package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayExample3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        Iterator<Integer> iterator = arrayList.iterator();
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            if(integer % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(arrayList);
    }
}

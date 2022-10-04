package org.example;

import org.example.homework1.MyArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>();
        List<String> stringList = new ArrayList<String>();
        List<Email> emailList = new ArrayList<Email>();

        List<Integer> integerList1 = new MyArrayList<Integer>();
        List<String> stringList1 = new MyArrayList<String>();
        List<Email> emailList1 = new MyArrayList<Email>();

        integerList.add(0, 3);
        System.out.println(integerList);
        integerList.add(1, 5);
        System.out.println(integerList);
        integerList.add(2, 7);
        System.out.println(integerList);
        integerList.add(1, 9);
        System.out.println(integerList);

        System.out.println(integerList.contains(3));
        System.out.println(integerList.get(3));
        System.out.println(integerList.indexOf(3));
        integerList.set(3, 6);
        integerList.remove(1);
        System.out.println(integerList);
    }
}

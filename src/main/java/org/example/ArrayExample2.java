package org.example;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class ArrayExample2 {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println("integers = " + integers.isEmpty());;
        System.out.println("integers = " + integers.size());

        ArrayList<String> strings = new ArrayList<>();
        System.out.println("strings = " + strings.isEmpty());
        System.out.println("strings.size() = " + strings.size());

        ArrayList<Email> emails = new ArrayList<>();
        System.out.println("emails = " + emails.isEmpty());
        System.out.println("emails.size() = " + emails.size());

        integers.add(3);
        integers.add(5);
        integers.add(7);
        integers.add(1, 10);
        System.out.println(integers);
        System.out.println("integers = " + integers.size());
    }
}

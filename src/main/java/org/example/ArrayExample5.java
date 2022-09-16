package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayExample5 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(4);

        System.out.println(arrayList);

        Integer[] integers = new Integer[5];
        integers = arrayList.toArray(integers);

        for(Integer integer : integers) {
            System.out.println("integer = " + integer);
        }

        Object[] objects = new Object[5];
        objects = arrayList.toArray(objects);

        for(Object o : objects) {
            System.out.println("o = " + o);
        }

        // Comparator는 인터페이스 인데 sort안에는 comparator가 들어간다.
        // 즉 인터페이스를 인자로 넣는 것인데, 이는 인터페이스를 구현한 클래스에 인자로 들어간다는 것이다.
        arrayList.sort(new MyIntegerComparator());

        System.out.println(arrayList);

        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2)
                    return 1;
                else if (o1 == o2) {
                    return 0;
                }
                else return -1;
            }
        });

        System.out.println(arrayList);

        ArrayList<Email> emails = new ArrayList<Email>();
        emails.add(new Email(5, 1));
        emails.add(new Email(3, 4));
        emails.add(new Email(2, 2));
        emails.add(new Email(4, 3));
        emails.add(new Email(1, 5));

        System.out.println(emails);

        emails.sort(new Comparator<Email>() {
            @Override
            public int compare(Email o1, Email o2) {
                if(o1.getFrom() < o2.getFrom())
                    return -1;
                else if (o1.getFrom() == o2.getFrom()) {
                    return 0;
                }
                else return 1;
            }
        });

        emails.sort(new Comparator<Email>() {
            @Override
            public int compare(Email o1, Email o2) {
                if(o1.getTo() < o2.getTo())
                    return 1;
                else if (o1.getTo() == o2.getTo()) {
                    return 0;
                }
                else return -1;
            }
        });

        System.out.println(emails);
    }
}

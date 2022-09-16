package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class App10 {

    public static Email[] getData() throws IOException{

        long pre = System.currentTimeMillis();

        Email[] emails = new Email[420045];
        int index = 0;
        BufferedReader br = new BufferedReader(new FileReader("/Users/yungwang-o/Downloads/email.txt"));
        while(true) {
            String s = br.readLine();
            if(s == null) break;
            if(s.startsWith("#")) continue;
            String[] array = s.split("\t");
            int from = Integer.parseInt(array[0]);
            int to = Integer.parseInt(array[1]);

            emails[index++] = new Email(from, to);
        }
        //System.out.println(System.currentTimeMillis() - pre); // 현재 시간 - 이전 시간 = 총 걸린 시간.
        br.close();

        return emails;
    }

    public static void main(String[] args) throws IOException {

        Email[] emails = getData();

        int higher = Integer.MAX_VALUE;
        int lower = Integer.MIN_VALUE;

        for(Email email : emails) {
            int from = email.from;
            int to = email.to;

            if(from < 100000 && from > lower) {
                lower = from;
            }
            if(to < 100000 && to > lower) {
                lower = to;
            }

            if(from > 100000 && from < higher) {
                higher = from;
            }
            if(to > 100000 && to < higher) {
                higher = to;
            }
        }
        System.out.println("higher = " + higher);
        System.out.println("lower = " + lower);

        // Tree Set
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(Email email : emails) {
            treeSet.add(email.from);
            treeSet.add(email.to);
        }
        System.out.println("treeSet = " + treeSet.lower(100000));
        System.out.println("treeSet.higher(100000) = " + treeSet.higher(100000));
        System.out.println("treeSet = " + treeSet.first());
        System.out.println("treeSet = " + treeSet.last());

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator = " + iterator.next());
        }
    }
}

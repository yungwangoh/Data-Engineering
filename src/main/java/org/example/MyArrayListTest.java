package org.example;

import org.example.homework1.MyArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MyArrayListTest {

    public static List<Email> getData() throws IOException{
        List<Email> emails = new MyArrayList<Email>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/yungwang-o/Downloads/email.txt"));
        int count = 0;
        while(true) {
            String s = br.readLine();
            if(s == null) break;
            if(s.startsWith("#")) continue;
            String[] array = s.split("\t");
            int from = Integer.parseInt(array[0]);
            int to = Integer.parseInt(array[1]);

            emails.add(new Email(from, to));
            System.out.println(++count);
        }
        //System.out.println(System.currentTimeMillis() - pre); // 현재 시간 - 이전 시간 = 총 걸린 시간.
        br.close();

        return emails;
    }

    public static void main(String[] args) throws IOException {
        long pre = System.currentTimeMillis();
        List<Email> emails = getData();
        System.out.println("적재 시간 : " + (System.currentTimeMillis() - pre));

        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Email email : emails) {
            int from = email.getFrom();
            int to = email.getTo();
            count++;

            if(from < min)
                min = from;
            if(from > max)
                max = from;

            if(to < min)
                min = to;
            if(to > max)
                max = to;

        }
        System.out.println("이벤트의 수 : " + count);
        System.out.println("최소 사람 ID : " + min);
        System.out.println("최대 사람 ID : " + max);
    }
}

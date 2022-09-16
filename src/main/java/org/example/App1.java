package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App1 {

    public static void eventLineCount(Email[] emails) {

        System.out.println("emails.length = " + emails.length);
    }
    public static void eventMax(Email[] emails) {
        int max = Integer.MIN_VALUE;

        for(Email email : emails) {
            if(email.from > max) max = email.from;
            if(email.to > max) max = email.to;
        }

        System.out.println("max = " + max);
    }
    public static void eventMin(Email[] emails) {
        int min = Integer.MAX_VALUE;

        for(Email email : emails) {
            if(email.from < min) min = email.from;
            if(email.to < min) min = email.to;
        }

        System.out.println("min = " + min);
    }
    public static void main(String[] args) throws IOException {

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
        eventLineCount(emails);
        eventMax(emails);
        eventMin(emails);

        System.out.println(System.currentTimeMillis() - pre); // 현재 시간 - 이전 시간 = 총 걸린 시간.
        br.close();
    }
}

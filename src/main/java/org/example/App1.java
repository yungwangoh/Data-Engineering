package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
        Email[] emails = new Email[420045];
        BufferedReader br = new BufferedReader(new FileReader("/Users/yungwang-o/Downloads/email.txt"));

        br.close();
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/Users/yungwang-o/Downloads/email.txt"));
        while(true) {
            String s = br.readLine();
            if(s == null) break;
            if(s.startsWith("#")) continue;

            String[] array = s.split("\t");
            int from = Integer.parseInt(array[0]);
            int to = Integer.parseInt(array[1]);
            Email email = new Email(from, to);
            System.out.println("from = " + email.from + " -> " + "to = " + email.to);
        }
        br.close();
    }
}

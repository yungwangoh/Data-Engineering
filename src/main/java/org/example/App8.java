package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App8 {

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

        for(Email email : emails) {
            if(email.from == 265213) {
                System.out.println("발견");
                System.exit(1);
            }
            if(email.to == 265213) {
                System.out.println("발견");
                System.exit(1);
            }
        }

        System.out.println("발견하지 못함");
    }
}

package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class App9 {

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

        HashSet<Integer> senders = new HashSet<Integer>();

        // from이 senders에 있는지 없는지 확인하고 있으면 무시하고, 없으면 추가한다.
        for(Email email : emails) {
            int from = email.from;
            senders.add(from); // hashset은 중복 없이 수가 들어간다.
        }
        // senders 는 보낸 사람의 ID를 중복없이 앞에서 부터 채워나감.
        System.out.println(senders.size());
    }
}

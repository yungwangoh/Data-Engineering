package org.example;

public class Email {
    // 데이터 추상화
    int from; // 보낸 사람
    int to; // 받는 사람

    // 프로시저 추상화

    public Email(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Email{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}

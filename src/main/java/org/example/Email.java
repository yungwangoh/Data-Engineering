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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return from == email.from && to == email.to;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}

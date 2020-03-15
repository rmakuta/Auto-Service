package pl.makuta;

import pl.makuta.model.Status;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String s = "ADDED";
        int i = 1;
        Status status = Status.valueOf(s);
        Status status1 = Status.ADDED;

        String d = "DELETED";
        System.out.println(s.equals(i));

        CharSequence obj = "hello";
        String str = "hello";
        System.out.println("output is: " + obj + "  " + str);

        LocalDate now = LocalDate.now();
        System.out.println(now);
        now = LocalDate.parse("2020-05-05");
        System.out.println(now);
        now = null;
        System.out.println(now);
    }
}

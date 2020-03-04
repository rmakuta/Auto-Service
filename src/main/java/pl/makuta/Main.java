package pl.makuta;

import pl.makuta.model.Status;

public class Main {
    public static void main(String[] args) {
        String s = "ADDED";
        int i = 1;
        Status status = Status.valueOf(s);
        Status status1 = Status.ADDED;

        String d = "DELETED";
        System.out.println(s.equals(i));
    }
}

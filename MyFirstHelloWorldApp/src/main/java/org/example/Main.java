package org.example;

public class Main {

    public static void main(String[] args) {
        String str = "toto";
        int n = 1;
        StringBuilder strBuilder = new StringBuilder(40);
        strBuilder.append("I");
        strBuilder.append(" say");
        strBuilder.append(" I am ");
        strBuilder.append(str);
        strBuilder.append(" number ");
        strBuilder.append(n);
        String msg = strBuilder.toString(); // msg = I say I am toto number 1
        System.out.println(msg);
        int pos = strBuilder.indexOf(" I am"); // can still work on the string builder
        String addendum = " will you tell him";
        strBuilder.insert(pos, addendum);
        msg = strBuilder.toString(); // msg = I say I am toto number 1
        System.out.println("Hello world!");
        System.out.println(msg);

        A a1 = new A(10);
        A a2 = new A(20);

        boolean isBool = false;

        A.swap(a1, a2);
        System.out.println("toto " + a1.i);
        System.out.println("tata " + a2.i);
        System.out.println("equality ? " + a1.equals(a2));

        int x = 20;
        Integer xWrapper = x;
        // assertFalse();

        Weekends day1 = Weekends.SATURDAY;
        Weekends day2 = Weekends.SUNDAY;

        switch (day1) {
            case SUNDAY -> {
                System.out.println("dimanche");
                break;
            }
            case SATURDAY -> System.out.println("samedi");
        }
        System.out.println("relative comparisons " + (day1.compareTo(day2)));
    }
    public enum Weekends {
        SATURDAY,
        SUNDAY;
    }

}




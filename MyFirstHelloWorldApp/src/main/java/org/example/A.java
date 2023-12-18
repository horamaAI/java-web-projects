package org.example;

public class A {
    int i;
    public A(int i) {
        this.i = i;
    }

    static void swap (A a1, A a2) {
        A buff = a1;
        a1 = a2;
        a2 = buff;
        System.out.println("in swap toto " + a1.i);
        System.out.println("in swap tata " + a2.i);
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("in equality check ");
//        return false;
        return this.i == ((A)obj).i;
    }
}

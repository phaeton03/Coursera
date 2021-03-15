package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger num2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger num11 = new BigInteger("1006");
        BigInteger num22 = new BigInteger("3306");
        System.out.println(karatsuba(num1,num2));
        System.out.println(num2.multiply(num1));

        int [] i = {4,3,-7,77,40,5};
        int [] a = Arrays.copyOfRange(i,0,3);
        System.out.println(Arrays.toString(a));
    }
    // z1*10^n+z3*10^n/2+z2
    public static BigInteger karatsuba (BigInteger x, BigInteger y){
        if ( returnSize(x) == 1 || returnSize(y) == 1) return x.multiply(y);
        else {
            int length = returnSize(x.min(y));
            length = length/2 + length % 2;         // Приводим к четному. Без этой строки будут проблемы с округлением
            BigInteger ten = new BigInteger("10");
            BigInteger a = x.divide(ten.pow(length));
            BigInteger b = x.mod(ten.pow(length));
            BigInteger c = y.divide(ten.pow(length));
            BigInteger d =  y.mod(ten.pow(length));
            BigInteger p = a.add(b);
            BigInteger q = c.add(d);
            BigInteger z1 = karatsuba(a,c);
            BigInteger z2 = karatsuba(b,d);
            BigInteger z3 = karatsuba(p,q).subtract(z1).subtract(z2);
            return  z1.multiply(ten.pow(length*2)).add(z3.multiply(ten.pow(length))).add(z2); // z1*10^n+z3*10^n/2+z2
        }
    }

    public static int returnSize(BigInteger x){
        String sx=x.toString();
        return sx.length();
    }
}
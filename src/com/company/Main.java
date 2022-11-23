package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.stream.IntStream;


public class Main {
    public static BigInteger bigInteger = BigInteger.ONE;
    public static BigDecimal bigDecimal = BigDecimal.ONE;
    public static BigInteger toTest = new BigInteger("1000");
    public static void main(String[] args) {
        int n =90000;
        long start2 = System.currentTimeMillis();
        factorialRekur(n);
        long stop2 = System.currentTimeMillis();
        System.out.println("czas rekurencyjnie= " +(stop2-start2));
        long start = System.currentTimeMillis();
        factorial(n);
        long stop = System.currentTimeMillis();
        System.out.println("czas iteracyjnie= " +(stop-start));
        long start3 = System.currentTimeMillis();
        factorialStream(n);
        long stop3 = System.currentTimeMillis();
        System.out.println("czas stream API= " +(stop3-start3));

    }
    public static BigDecimal factorial(int n){
        BigDecimal result = BigDecimal.valueOf(1);
        if (n ==0){
            return BigDecimal.ONE;
        }
        for (int i = 1; i<=n; i++){
            result=result.multiply(BigDecimal.valueOf(i));


        }

        return result;


    }
    public static BigInteger factorialRekur(int n){
        if (n < 1){
            return BigInteger.valueOf(1);
        }
       return bigInteger.valueOf(n).multiply(factorialRekur(n-1));

    }
    public static BigInteger factorialStream(int n){
        if (n==2){
            return BigInteger.ONE;
        }else{
            return IntStream.rangeClosed(2,n).parallel().mapToObj(BigInteger::valueOf).reduce(BigInteger::multiply).get();


        }




    }


}

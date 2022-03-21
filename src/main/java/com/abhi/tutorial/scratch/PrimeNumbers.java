package com.abhi.tutorial.scratch;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static int[] listOfPrimesTillNumber(int num) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= num ; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        double limit = Math.sqrt(num);
        for (int i = 3; i <= limit; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] result = listOfPrimesTillNumber(20);
        for (int num : result) {
            System.out.println(num);
        }
    }
}

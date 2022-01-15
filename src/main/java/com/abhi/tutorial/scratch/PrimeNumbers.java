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

    private static boolean isPrime(int num) {
        double limit = Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] result = listOfPrimesTillNumber(1000000);
        for (int num : result) {
            System.out.println(num);
        }
    }
}

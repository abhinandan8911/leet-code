package com.abhi.tutorial.scratch;

public class RotateArray {

    public static int[] rotateArrayByOne(int[] array) {
        int len = array.length;
        int temp = array[0];
        for (int i = 0; i < len - 1; i++) {
            array[i] = array[i + 1];
        }
        array[len - 1] = temp;
        return array;
    }

    public static void main(String[] args) {
        int[] result = rotateArrayByOne(new int[]{1, 2, 3, 4});
        for (int num : result) {
            System.out.println(num);
        }
    }
}

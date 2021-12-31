package com.abhi.tutorial.bloomberg;

public class StringCompressionSecond {
    public static int compress(char[] chars) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < chars.length;) {
            int count = 0;
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == chars[i]) {
                    count++;
                }
                else {
                    break;
                }
            }
            stringBuffer.append(chars[i]);
            if (count > 1) {
                stringBuffer.append(count);
            }
            i = i + count;
        }
        String result = stringBuffer.toString();
        char[] resultArray = result.toCharArray();
        System.arraycopy(resultArray, 0, chars, 0, resultArray.length);
        return result.length();
    }

    public static void main(String[] args) {
        char[] input = {'a','a','a','b','b','a', 'a'};
        System.out.println(compress(input));
        for (char c : input) {
            System.out.println(c);
        }
    }
}

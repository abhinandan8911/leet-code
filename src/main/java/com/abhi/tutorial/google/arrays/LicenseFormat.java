package com.abhi.tutorial.google.arrays;

import java.util.ArrayList;
import java.util.List;

public class LicenseFormat {

    public String licenseKeyFormatting(String s, int k) {
        String upperS = s.toUpperCase();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < upperS.length(); i++) {
            char ch = upperS.charAt(i);
            if(ch != '-') {
                chars.add(ch);
            }
        }
        List<Character> result = new ArrayList<>();
        int idx = 0;
        if (chars.size() % k != 0) {
            int mod = chars.size() % k;
            while(idx < mod) {
                result.add(chars.get(idx++));
            }
            result.add('-');
        }
        int count = 0;
        while(idx < chars.size()) {
            if (count != 0 && count % k == 0) {
                result.add('-');
            }
            result.add(chars.get(idx));
            idx++;
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String in = "2-5g-3-J";
        LicenseFormat obj = new LicenseFormat();
        System.out.println(obj.licenseKeyFormatting(in, 2));
    }
}

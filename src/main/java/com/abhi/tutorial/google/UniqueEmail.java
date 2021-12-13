package com.abhi.tutorial.google;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] splitted = email.split("@");
            String localName = splitted[0];
            int indexOfPlus = localName.indexOf("+");
            if (indexOfPlus != -1) {
                localName = localName.substring(0, localName.indexOf("+"));
            }
            localName = localName.replace(".", "");
            String newEmail = localName + "@" + splitted[1];
            uniqueEmails.add(newEmail);
        }
        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] input = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        System.out.println(numUniqueEmails(input));
    }
}

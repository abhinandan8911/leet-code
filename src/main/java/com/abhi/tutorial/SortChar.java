package com.abhi.tutorial;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortChar {
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : chars) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sortedMap = frequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()){
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}

package com.abhi.tutorial;

import java.util.*;
import java.util.stream.Collectors;

public class FrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> frequencyMap = new TreeMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> sortedMap = frequencyMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        sortedMap.entrySet().stream().limit(k).forEach(e -> result.add(e.getKey()));
        return result;
    }

    public static void main(String[] args) {
        String[] input = {"i","love","leetcode","i","love","coding"};
        List<String> result = topKFrequent(input, 2);
        result.forEach(System.out::println);
    }
}

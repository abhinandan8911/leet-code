package com.abhi.tutorial.scratch;

import java.util.*;
import java.util.stream.Collectors;

public class MultiValuedMap {
    public Map<String, List<Integer>> createMap(List<String> names) {
        Map<String, List<Integer>> result = new HashMap<>();
        int count = 0;
        for (String name : names) {
            result.computeIfAbsent(name, str -> new ArrayList<>()).add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Abhi", "Abhi", "Sarita");
        Map<String, List<Integer>> result = (new MultiValuedMap()).createMap(names);
        result.forEach((k, v) -> {
            System.out.println("Key :: " + k + " and Value :: " + v.stream().map(String::valueOf).collect(Collectors.joining(" , ")));
        });
    }
}

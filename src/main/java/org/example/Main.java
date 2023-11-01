package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana","banana","a","a","a","apple", "cherry",  "banana", "date", "cherry", "apple", "date","date");

        System.out.println(words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        wordsList -> wordsList.stream()
                                                .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))
                                                .distinct()
                                                .collect(Collectors.toList())))))
                .entrySet()
                .stream()
                .max((entry1, entry2) -> Long.compare(entry1.getKey(), entry2.getKey()))
                .map(Map.Entry::getValue)
                .orElse(null));

    }
}
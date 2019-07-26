package com.company.Services;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextService {

    private String[] text(String text) {
        Pattern word = Pattern.compile("[^а-яА-Я]");
        return word.split(text);
    }

    public Map<String, Long> repetitions(String text) {
        return Stream.of(text.split("(?iu)\\b[^а-я]+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    public Set<String> uniqueWords(String text) {
        return repetitions(text).keySet();
    }

    public List<String> sortWordsByAlphabet(String text) {
        return uniqueWords(text).stream().sorted().collect(Collectors.toList());
    }

    public Set<String> sortWordsByLength(String text, Comparator<String> comparator) {
        String[] words = text(text);
        Arrays.sort(words, comparator);
        return new LinkedHashSet<>(Arrays.asList(words));
    }
}

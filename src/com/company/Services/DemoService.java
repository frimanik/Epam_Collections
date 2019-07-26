package com.company.Services;

import com.company.Repository.Text;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DemoService {
    public void run() {
        TextService textService = new TextService();
        String text = Text.Text;

        Map<String, Long> repetitions = textService.repetitions(text);
        System.out.println("Repetitions:");
        repetitions.forEach((word, Long) -> System.out.printf("%s - %d%n", word, Long));
        System.out.println();

        Set<String> unique = textService.uniqueWords(text);
        System.out.println("Unique words:");
        unique.forEach(System.out::println);
        System.out.println();

        List<String> sortedAlphabet = textService.sortWordsByAlphabet(text);
        System.out.println("Sort by alphabet:");
        sortedAlphabet.forEach(System.out::println);
        System.out.println();

        Comparator stringComparator = new Comparator<String>();
        Set<String> sortedLength = textService.sortWordsByLength(text, stringComparator);
        System.out.println("Sort by length:");
        sortedLength.forEach(System.out::println);
    }
}
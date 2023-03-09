package com.global.commtech.test.anagramfinder;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AnagramGrouper {
    public Stream<String> group(Stream<String> lines) {
        return lines
            //map to a list of words paired with a list of frequencies of each character in the word
            .map(line -> new Frequency(line, line
                    .chars()
                    .boxed()
                    .collect(Collectors.groupingByConcurrent(c -> c, Collectors.counting()))))
            //groupBy identical frequency lists
            .collect(Collectors.groupingByConcurrent(Frequency::frequency))
            .values()
            .parallelStream()
            //join words with identical frequency lists
            .map(m -> m
                    .stream()
                    .map(Frequency::word)
                    //requirement that output array be sorted
                    .sorted()
                    .collect(Collectors.joining(",")));
    }
}

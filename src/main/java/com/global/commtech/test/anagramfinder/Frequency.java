package com.global.commtech.test.anagramfinder;

import java.util.Map;

public record Frequency(String word, Map<Integer, Long> frequency){}

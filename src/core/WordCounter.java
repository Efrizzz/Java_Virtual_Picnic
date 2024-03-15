package src.core;

import java.util.HashMap;

public interface WordCounter {
    int countWords();
    String findLongestWord();
    HashMap<String, Integer> calculateWordFrequency();
}
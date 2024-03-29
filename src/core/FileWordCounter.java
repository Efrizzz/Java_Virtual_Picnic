package src.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWordCounter implements WordCounter {
    private String fileName;

    public FileWordCounter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public int countWords() {
        int wordCount = 0;
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    scanner.next();
                    wordCount++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordCount;
    }

    @Override
    public String findLongestWord() {
        String longestWord = "";
        HashMap<String, Integer> wordsOfMaxLength = new HashMap<>();
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                        wordsOfMaxLength.clear();
                        wordsOfMaxLength.put(longestWord, 1);
                    } else if (word.length() == longestWord.length() && !wordsOfMaxLength.containsKey(word)) {
                        wordsOfMaxLength.put(word, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return String.join(", ", wordsOfMaxLength.keySet());
    }

    @Override
    public HashMap<String, Integer> calculateWordFrequency() {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordFrequency;
    }
}

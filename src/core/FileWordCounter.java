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
        try {
            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String word = scanner.next();
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return longestWord;
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

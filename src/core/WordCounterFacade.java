package src.core;

import java.util.Map;

public class WordCounterFacade {
    private WordCounter wordCounter;

    public WordCounterFacade(String fileName) {
        wordCounter = new FileWordCounter(fileName);
    }

    public void printWordCount() {
        System.out.println("Количество слов в файле: " + wordCounter.countWords());
    }

    public void printLongestWord() {
        System.out.println("Самое длинное слово в файле: " + wordCounter.findLongestWord());
    }

    public void printWordFrequency() {
        Map<String, Integer> wordFrequency = wordCounter.calculateWordFrequency();
        System.out.println("Частота слов в файле:");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
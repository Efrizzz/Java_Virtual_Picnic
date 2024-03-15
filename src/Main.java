package src;

import src.core.*;

public class Main {
    public static void main(String[] args) {
        WordCounterFacade wordCounterFacade = new WordCounterFacade
        ("C:\\Users\\ALFA\\Desktop\\GeekBrains\\Java_Virtual_Picnic\\src\\input.txt");


        wordCounterFacade.printWordCount();
        wordCounterFacade.printLongestWord();
        wordCounterFacade.printWordFrequency();
    }
}


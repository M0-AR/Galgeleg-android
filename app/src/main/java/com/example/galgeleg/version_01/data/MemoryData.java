package com.example.galgeleg.version_01.data;

import com.example.galgeleg.version_01.factory_word.Word;

public class MemoryData extends Word {

    public MemoryData() {
        addWords();
        setWord(getRandomWord());
    }

    private void addWords() {
        listOfWords.add("bil");
        listOfWords.add("computer");
        listOfWords.add("programmering");
        listOfWords.add("motorvej");
        listOfWords.add("busrute");
        listOfWords.add("gangsti");
        listOfWords.add("skovsnegl");
        listOfWords.add("solsort");
        listOfWords.add("nitten");
    }


}

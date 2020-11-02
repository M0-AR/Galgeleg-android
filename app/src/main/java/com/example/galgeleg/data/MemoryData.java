package com.example.galgeleg.data;

import com.example.galgeleg.factory_word.Word;

public class MemoryData extends Word {

    public MemoryData() {
        addWords();
        setWord(getRandomWord());
    }

    private void addWords() {
        // Todo Add or delete some words
        muligeOrd.add("bil");
//        muligeOrd.add("computer");
//        muligeOrd.add("programmering");
//        muligeOrd.add("motorvej");
//        muligeOrd.add("busrute");
//        muligeOrd.add("gangsti");
//        muligeOrd.add("skovsnegl");
//        muligeOrd.add("solsort");
//        muligeOrd.add("nitten");
    }


}

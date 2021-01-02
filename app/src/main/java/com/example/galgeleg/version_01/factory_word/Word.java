package com.example.galgeleg.version_01.factory_word;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public abstract class Word {
    protected ArrayList<String> muligeOrd = new ArrayList<String>();

    private String word;
    public String getWord() {
        return word;
    }
    protected void setWord(String word) {
        this.word = word;
    }




    protected static String hentUrl(String url) throws IOException {
        System.out.println("Henter data fra " + url);

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    protected String getRandomWord() {
        int i = new Random().nextInt(muligeOrd.size());
        return muligeOrd.get(i);
    }

}

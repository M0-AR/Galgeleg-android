package com.example.galgeleg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResultActivity extends Activity {
    public static final String FILE_NAME = "result.txt";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);
        load();
        Bundle bundle = getIntent().getExtras();

        String text = bundle.getString(MainActivity.RESULT_TEXT);
        String correctLetters = bundle.getString(MainActivity.CORRECT_LETTERS);
        String wrongLetters = bundle.getString(MainActivity.WRONG_LETTERS);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(text);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(getString(R.string.correct_letters) + correctLetters);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(getString(R.string.wrong_letters) + wrongLetters);

        save();
    }


    public void load() {
        try(FileInputStream fis = openFileInput(FILE_NAME)) {
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null)
                sb.append(text).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {

    }


}


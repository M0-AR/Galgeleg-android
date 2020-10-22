package com.example.galgeleg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {

        }
        String text = bundle.getString(MainActivity.RESULT_TEXT);
        String correctLetters = bundle.getString(MainActivity.CORRECT_LETTERS);
        String wrongLetters = bundle.getString(MainActivity.WRONG_LETTERS);
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(text);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(getString(R.string.correct_letters) + correctLetters);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(getString(R.string.wrong_letters) + wrongLetters);

    }
}


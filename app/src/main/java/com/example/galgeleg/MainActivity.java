package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.factory.Word;
import com.example.galgeleg.factory.WordFactory;

import static com.example.galgeleg.Constants.WORD;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private WordFactory wordFactory;
    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordFactory = new WordFactory();

        Button memoryButton = findViewById(R.id.memory_button);
        memoryButton.setOnClickListener(this);
        Button googleSheetButton = findViewById(R.id.google_sheet_button);
        googleSheetButton.setOnClickListener(this);
        Button websiteButton = findViewById(R.id.website_button);
        websiteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.memory_button:
            {
               word = wordFactory.makeData(0);
               goToGameActivity(word.getWord());
            }break;
            case R.id.google_sheet_button:
            {
                word = wordFactory.makeData(1);
                goToGameActivity(word.getWord());
            }break;
            case R.id.website_button:
            {
                word = wordFactory.makeData(2);
                goToGameActivity(word.getWord());
            }break;
        }
    }


    public void goToGameActivity(String word) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(WORD, word);
        startActivity(intent);
    }
}
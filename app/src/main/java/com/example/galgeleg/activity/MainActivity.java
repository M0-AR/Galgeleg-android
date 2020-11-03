package com.example.galgeleg.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.R;
import com.example.galgeleg.dialog.SearchWordDialog;
import com.example.galgeleg.factory_word.Word;
import com.example.galgeleg.factory_word.DataFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.example.galgeleg.Constants.WORD;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DataFactory dataFactory;
    private Word word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataFactory = new DataFactory();

        Button memoryButton = findViewById(R.id.memory_button);
        memoryButton.setOnClickListener(this);
        Button googleSheetButton = findViewById(R.id.google_sheet_button);
        googleSheetButton.setOnClickListener(this);
        Button websiteButton = findViewById(R.id.website_button);
        websiteButton.setOnClickListener(this);

        // To avoid android.os.NetworkOnMainThreadException
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    static Executor bgThread = Executors.newSingleThreadExecutor(); // håndtag til en baggrundstrå
    static Handler uiThread = new Handler(Looper.getMainLooper());  // håndtag til forgrundstråden

    @Override
    public void onClick(View v) {
        openDialog();
        switch (v.getId()) {
            case R.id.memory_button:
            {
               word = dataFactory.makeData(0);
               goToGameActivity(word.getWord());
            }break;
            case R.id.google_sheet_button:
            {
                bgThread.execute(() -> {
                    word = dataFactory.makeData(1);
                    uiThread.post(() -> goToGameActivity(word.getWord()));
                });
            }break;
            case R.id.website_button:
            {
                bgThread.execute(() -> {
                    word = dataFactory.makeData(2);
                    uiThread.post(() -> goToGameActivity(word.getWord()));
                });
            }break;
        }
    }


    public void openDialog() {
        final SearchWordDialog lottie=new SearchWordDialog(this);
        lottie.show();
    }

    public void goToGameActivity(String word) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(WORD, word);
        startActivity(intent);
        finish();
    }
}
package com.example.galgeleg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
// https://stackoverflow.com/questions/4118751/how-do-i-serialize-an-object-and-save-it-to-a-file-in-android
// https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array
// https://stackoverflow.com/questions/31339075/getting-multiple-objects-from-serialization-in-java

public class ResultActivity extends Activity {
    public static final String FILE_NAME = "result.txt";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ResultItem> mResultItemList = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);
        load();
        Bundle bundle = getIntent().getExtras();

        String text = bundle.getString(MainActivity.RESULT_TEXT);
        String correctLetters = getString(R.string.correct_letters) + bundle.getString(MainActivity.CORRECT_LETTERS);
        String wrongLetters = getString(R.string.wrong_letters) + bundle.getString(MainActivity.WRONG_LETTERS);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(text);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(correctLetters);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText( wrongLetters);

        save(text, correctLetters, wrongLetters);
    }


    public void load() {
        try(FileInputStream fis = openFileInput(FILE_NAME);
            ObjectInputStream is = new ObjectInputStream(fis)) {
            while (true) {
                ResultItem resultItem = (ResultItem) is.readObject();
                if (resultItem != null)
                    mResultItemList.add(resultItem);
                else
                    break;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save(String resultText, String correctLetters, String wrongLetters) {
        try (FileOutputStream fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
             ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(new ResultItem(resultText, correctLetters, wrongLetters));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


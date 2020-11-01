package com.example.galgeleg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
// https://stackoverflow.com/questions/4118751/how-do-i-serialize-an-object-and-save-it-to-a-file-in-android
// https://stackoverflow.com/questions/27409718/java-reading-multiple-objects-from-a-file-as-they-were-in-an-array
// https://stackoverflow.com/questions/31339075/getting-multiple-objects-from-serialization-in-java

public class ResultActivity extends Activity {
    public static final String FILE_NAME = "result.ser";

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ResultItem> mResultItemList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_result);

        loadData();
        Bundle bundle = getIntent().getExtras();

        String text = bundle.getString(MainActivity.RESULT_TEXT);
        String correctLetters = getString(R.string.correct_letters) + bundle.getString(MainActivity.CORRECT_LETTERS);
        String wrongLetters = getString(R.string.wrong_letters) + bundle.getString(MainActivity.WRONG_LETTERS);
        mResultItemList.add(new ResultItem(text, correctLetters, wrongLetters));

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(text);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(correctLetters);
        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText( wrongLetters);

        saveData();
    }




    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mResultItemList);
        editor.putString("task list", json);
        editor.apply();
    }
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<ResultItem>>() {}.getType();
        mResultItemList = gson.fromJson(json, type);
        if (mResultItemList == null) {
            mResultItemList = new ArrayList<>();
        }
    }


    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ResultAdapter(mResultItemList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }



}


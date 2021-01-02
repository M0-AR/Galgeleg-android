package com.example.galgeleg.version_01.activity;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.item.*;
import com.example.galgeleg.version_01.adapter.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.example.galgeleg.version_01.utilities.Constants.*;

public class ResultActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<ResultItem> mResultItemList;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_item);

        loadData();

        Bundle bundle =  getIntent().getExtras();
        final ResultItem resultItem = (ResultItem) bundle.getSerializable(OBJECT);
        mResultItemList.add(resultItem);

        buildRecyclerView();
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
        mRecyclerView = findViewById(R.id.recycler_view_for_result);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ResultAdapter(mResultItemList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        //moveTaskToBack(true); // exist app
        finish();
    }


}


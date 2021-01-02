package com.example.galgeleg.version_01.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.adapter.WordListAdapter;
import com.example.galgeleg.version_01.utilities.SampleData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordFromList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_from_list);

        buildRecyclerView();
    }

    private void buildRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_for_word_list);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        WordListAdapter mAdapter = new WordListAdapter(SampleData.listOfWords, getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(
                mRecyclerView.getContext(), mLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        //moveTaskToBack(true); // exist app
        finish();
    }

}
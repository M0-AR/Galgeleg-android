package com.example.galgeleg.version_01.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.adapter.*;
import com.example.galgeleg.version_01.utilities.SampleData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.galgeleg.version_01.utilities.Constants.PLAYER_NAME;
import static com.example.galgeleg.version_01.utilities.Constants.WORD;

public class WordFromList extends AppCompatActivity implements WordListAdapter.GetWord{

    String mPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_from_list);
        Bundle bundle =  getIntent().getExtras();
        mPlayerName =  bundle.get(PLAYER_NAME)+"";
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_for_word_list);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        WordListAdapter mAdapter = new WordListAdapter(SampleData.listOfWords, getApplicationContext(), this);
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

    @Override
    public void onGettingWord(String word) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(WORD, word);
        intent.putExtra(PLAYER_NAME, mPlayerName);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivities(new Intent[]{intent});
    }
}
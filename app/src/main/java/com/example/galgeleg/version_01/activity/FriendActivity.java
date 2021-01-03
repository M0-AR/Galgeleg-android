package com.example.galgeleg.version_01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.galgeleg.R;
import com.example.galgeleg.version_01.factory_word.Word;

import static com.example.galgeleg.version_01.utilities.Constants.PLAYER_NAME;

public class FriendActivity extends AppCompatActivity {
    public static final String TAG = "PlayerInformation";
    private String mPlayerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_information);

        EditText mEditText = findViewById(R.id.player_name);


        Button pickWord = findViewById(R.id.pick_word);
        pickWord.setOnClickListener(v -> {
            Intent intent = new Intent(this, WordFromList.class);
            mPlayerName =  mEditText.getText().toString().trim();
            Log.d(TAG, "playerName: " + mPlayerName);
            intent.putExtra(PLAYER_NAME, mPlayerName);
            startActivity(intent);
            finish();
        });

    }



}
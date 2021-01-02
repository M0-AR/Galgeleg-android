package com.example.galgeleg.version_01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.R;

public class AloneOrWithFriends extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alone_or_with_friends);


        Button playAlone = findViewById(R.id.play_alone);
        playAlone.setOnClickListener(this);
        Button playWithFriends = findViewById(R.id.play_with_friends);
        playWithFriends.setOnClickListener(this);
        Button friendsHistory = findViewById(R.id.friends_history);
        friendsHistory.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_alone:
            {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

            }break;
            case R.id.play_with_friends:
            {
                Intent intent = new Intent(this, PlayerInformation.class);
                startActivity(intent);
            }break;
            case R.id.friends_history:
            {

            }break;
        }
    }
}
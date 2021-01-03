package com.example.galgeleg.version_01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Intent intent = new Intent(this, AloneActivity.class);
                startActivity(intent);

            }break;
            case R.id.play_with_friends:
            {
                Intent intent = new Intent(this, FriendActivity.class);
                startActivity(intent);
            }break;
            case R.id.friends_history:
            {

            }break;
        }
    }

    private boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAndRemoveTask();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
package com.example.galgeleg.version_01.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.galgeleg.version_01.Galgelogik;
import com.example.galgeleg.R;
import com.example.galgeleg.version_01.model.*;

import java.util.Date;

import static com.example.galgeleg.version_01.utilities.Constants.OBJECT;
import static com.example.galgeleg.version_01.utilities.Constants.PLAYER_NAME;
import static com.example.galgeleg.version_01.utilities.Constants.WORD;

public class GameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private GridView mGridView;
    private ImageView mImageView;
    private String mPlayerName;
    private MediaPlayer mMediaPlayer;
    private TextView mWordLength, mNumberOfTrial, mCorrectLetter, mWrongLetter;

    //Galgelogik spil = new Galgelogik(this);

    Galgelogik spil = Galgelogik.getInstance(this);

    final String[] gridViewValues = {
            "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z", "æ", "ø", "å"
    };

    final int[] images = {R.drawable.galge,
                          R.drawable.forkert1,
                          R.drawable.forkert2,
                          R.drawable.forkert3,
                          R.drawable.forkert4,
                          R.drawable.forkert5,
                          R.drawable.forkert6};

    int imageTrackingIndex = -1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mWordLength = findViewById(R.id.word_length);
        mNumberOfTrial = findViewById(R.id.number_of_trial);
        mCorrectLetter = findViewById(R.id.correct_letter);
        mWrongLetter = findViewById(R.id.wrong_letter);

        Bundle bundle =  getIntent().getExtras();
        String word =  bundle.get(WORD)+"";
        mWordLength.setText("The number of letters is: " + word.length());
        mPlayerName = bundle.get(PLAYER_NAME)+"";

        spil.startNytSpil(word);
        mGridView = findViewById(R.id.gridView);

        int resID = R.layout.letterlist_item;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, resID, gridViewValues);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
        mImageView = findViewById(R.id.imageView);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String getLetter = ((TextView) view).getText()+"";
        spil.gætBogstav(getLetter);

        mNumberOfTrial.setText(getString(R.string.win_message) + ": " + spil.getAntalForsøg());
        if (spil.erSidsteBogstavKorrekt()) {
            Toast.makeText(getApplicationContext(),
                    getLetter + " " + getString(R.string.correct_letter), Toast.LENGTH_SHORT).show();
            spil.mCorrectLettersTheUserUsed.add(getLetter);
            mCorrectLetter.setText("Correct letter: " + spil.mCorrectLettersTheUserUsed);
            spil.erSpilletVundet();

        } else {
            Toast.makeText(getApplicationContext(),
                    getLetter + " " + getString(R.string.wrong_letter), Toast.LENGTH_SHORT).show();
            spil.mWrongLettersTheUserUsed.add(getLetter);
            mWrongLetter.setText("Wrong letter: " + spil.mWrongLettersTheUserUsed);
            spil.erSpilletTabt();
            mImageView.setImageResource(images[++imageTrackingIndex]);
        }
    }

    @SuppressLint("NewApi")
    public void survive() {
        playWinningSound();
        String mResultDescription = "You wonnnnnn\n" +  getString(R.string.win_message) + " " + spil.getAntalForsøg();
        startResultActivity(new ResultItem(mResultDescription,
                "Correct Letters: " + String.join(" ",spil.mCorrectLettersTheUserUsed),
                 "Wrong letters: " + String.join(" ", spil.mWrongLettersTheUserUsed), new Date()));
    }

    private void playWinningSound() {
        mMediaPlayer = MediaPlayer.create(this, R.raw.clap_sound);
        mMediaPlayer.start();
    }


    @SuppressLint("NewApi")
    public void dead() {
        playDeadSound();
        String mResultDescription = getString(R.string.lose_message) + " " + spil.getOrdet();
        startResultActivity(new ResultItem(mResultDescription,
                "Correct Letters: " + String.join(" ",spil.mCorrectLettersTheUserUsed),
                "Wrong letters: " + String.join(" ", spil.mWrongLettersTheUserUsed), new Date()));
    }

    private void playDeadSound() {
        mMediaPlayer = MediaPlayer.create(this, R.raw.knif_sound);
        mMediaPlayer.start();
    }
    public void startResultActivity(ResultItem resultItem) {
        Intent intent = new Intent(GameActivity.this, ResultActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        Bundle bundle = new Bundle();
        bundle.putSerializable(OBJECT, resultItem);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AloneOrWithFriends.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}



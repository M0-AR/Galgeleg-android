package com.example.galgeleg.version_01.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.galgeleg.version_01.Galgelogik;
import com.example.galgeleg.R;
import com.example.galgeleg.version_01.dialog.ResultDialog;
import com.example.galgeleg.version_01.item.*;

import java.util.Date;

import static com.example.galgeleg.version_01.Constants.OBJECT;
import static com.example.galgeleg.version_01.Constants.WORD;

//ImageView
// https://stackoverflow.com/questions/8051069/how-to-show-image-using-imageview-in-android
// Update Image
// https://stackoverflow.com/questions/44214136/what-does-r-drawable-image-return
// https://stackoverflow.com/questions/38596461/creating-multiple26-buttons-in-one-layout-screen
// https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet
// https://stackoverflow.com/questions/24597634/how-to-generate-an-array-of-alphabet-in-jquery
// https://www.youtube.com/watch?v=bff46pNqT8Y
// https://mkyong.com/android/android-gridview-example/
// color for every item in grid
// https://stackoverflow.com/questions/38700097/how-to-apply-different-colors-for-gridview-row-items-in-android
// Simple Dialog
// https://developer.android.com/guide/topics/ui/dialogs.html
// https://stackoverflow.com/questions/42042248/how-to-pass-data-from-activity-to-dialogfragment
// https://www.youtube.com/watch?v=Bsm-BlXo2SI
// https://www.youtube.com/watch?v=n8oasrJs_eY
// https://www.youtube.com/watch?v=_sOHZAk6KnA +  https://github.com/afollestad/material-dialogs
// Intent : don't forget to define new activity in AndroidManifest.xml
// https://codinginflow.com/tutorials/android/open-a-new-activity-and-pass-variables
// Add language
// https://www.youtube.com/watch?v=72qURZPIUIA
// https://stackoverflow.com/questions/2183962/how-to-read-value-from-string-xml-in-android
// https://stackoverflow.com/questions/5341151/problems-with-positioning-textview-under-another-textview-in-relative-layout
// https://stackoverflow.com/questions/9379023/sending-multiple-variable-values-to-another-activity
public class GameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    GridView mGridView;
    ImageView mImageView;


    //Galgelogik spil = new Galgelogik(this);

    Galgelogik spil = Galgelogik.getInstance(this);

    final String[] gridViewValues = {
            "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x",
            "y", "z", "æ", "ø", "å"
    };

    final int[] images = {R.drawable.forkert1,
                          R.drawable.forkert2,
                          R.drawable.forkert3,
                          R.drawable.forkert4,
                          R.drawable.forkert5,
                          R.drawable.forkert6};

    int imageTrackingIndex = -1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle bundle =  getIntent().getExtras();
         String word =  bundle.get(WORD)+"";

         //spil.startNytSpil(word);

        mGridView = findViewById(R.id.gridView);

        int resID = R.layout.letterlist_item;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, resID, gridViewValues);

        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
        mImageView = findViewById(R.id.imageView);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String getLetter = ((TextView) view).getText()+"";
        spil.gætBogstav(getLetter);
        if (spil.erSidsteBogstavKorrekt()) {
            Toast.makeText(getApplicationContext(),
                    getLetter + " " + getString(R.string.correct_letter), Toast.LENGTH_SHORT).show();
            spil.mCorrectLettersTheUserUsed.add(getLetter);
        } else {
            if (imageTrackingIndex == images.length-1) {
                spil.erSpilletVundet();
                spil.erSpilletTabt();
            } else {
                mImageView.setImageResource(images[++imageTrackingIndex]);
            }
            Toast.makeText(getApplicationContext(),
                    getLetter + " " + getString(R.string.wrong_letter), Toast.LENGTH_SHORT).show();
            spil.mWrongLettersTheUserUsed.add(getLetter);
        }
    }


    @SuppressLint("NewApi")
    public void survive() {
        String mResultDescription = "You wonnnnnn\n" +  getString(R.string.win_message) + " " + spil.getAntalForsøg();
        openDialog(new ResultItem(mResultDescription,
                "Correct Letters: " + String.join(" ",spil.mCorrectLettersTheUserUsed),
                 "Wrong letters: " + String.join(" ", spil.mWrongLettersTheUserUsed), new Date()));
    }


    @SuppressLint("NewApi")
    public void dead() {
       String mResultDescription = getString(R.string.lose_message) + " " + spil.getOrdet();
        openDialog(new ResultItem(mResultDescription,
                "Correct Letters: " + String.join(" ",spil.mCorrectLettersTheUserUsed),
                "Wrong letters: " + String.join(" ", spil.mWrongLettersTheUserUsed), new Date()));
    }

    public void openDialog(ResultItem resultItem) {
        ResultDialog resultDialog = new ResultDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(OBJECT, resultItem);
        resultDialog.setArguments(bundle);
        resultDialog.show(getSupportFragmentManager(), "example dialog");
    }
}



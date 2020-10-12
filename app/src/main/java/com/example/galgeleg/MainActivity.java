package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
public class MainActivity extends AppCompatActivity {

    GridView mGridView;
    ImageView mImageView;

    Galgelogik spil = new Galgelogik();

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

    int imageTracking = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spil.startNytSpil();

        mGridView = findViewById(R.id.gridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, gridViewValues);
        mGridView.setAdapter(adapter);

        mImageView = findViewById(R.id.imageView);


        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                spil.gætBogstav((String) ((TextView) view).getText());
                if (spil.erSidsteBogstavKorrekt()) {
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText() + " is correct", Toast.LENGTH_SHORT).show();
                } else {
                    mImageView.setImageResource(images[++imageTracking]);
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText() + " is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
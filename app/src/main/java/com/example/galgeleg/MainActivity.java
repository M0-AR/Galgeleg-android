package com.example.galgeleg;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
// Simple Dialog
// https://developer.android.com/guide/topics/ui/dialogs.html
// https://stackoverflow.com/questions/42042248/how-to-pass-data-from-activity-to-dialogfragment
// https://www.youtube.com/watch?v=Bsm-BlXo2SI
// https://www.youtube.com/watch?v=n8oasrJs_eY
// https://www.youtube.com/watch?v=_sOHZAk6KnA +  https://github.com/afollestad/material-dialogs
public class MainActivity extends AppCompatActivity {

    GridView mGridView;
    ImageView mImageView;
    Dialog mDialog;

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

  /*  @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
                    if (imageTracking == images.length-1)
                        imageTracking = -1;
                    mImageView.setImageResource(images[++imageTracking]);
                    Toast.makeText(getApplicationContext(),
                            ((TextView) view).getText() + " is wrong", Toast.LENGTH_SHORT).show();
                }

                String textIWantToSee;

                if (spil.erSpilletVundet()) {
                    //openDialog();
                   // simpleDialog("Antal forsøg: " + spil.getAntalForsøg());

*//*
                    textIWantToSee = "Antal forsøg: " + spil.getAntalForsøg();
                    simpleDialogFragment dialogFragment = new simpleDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("TEXT",textIWantToSee);
                    dialogFragment.setArguments(bundle);
                    dialogFragment.show((MainActivity.this).getSupportFragmentManager(),"Image Dialog");
*//*
                }

                if (spil.erSpilletTabt()) {
*//*
                    textIWantToSee = "Du har tabt! Ordet var: " + spil.getOrdet();
                    simpleDialogFragment dialogFragment = new simpleDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("TEXT",textIWantToSee);
                    dialogFragment.setArguments(bundle);
                    dialogFragment.show((MainActivity.this).getSupportFragmentManager(),"Image Dialog");
*//*
                   openDialog();
                   //simpleDialog("Du har tabt! Ordet var: " + spil.getOrdet());
                }
            }
        });
    }*/

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    // Not working
//    public void openDialog() {
//        simpleDialogFragment dialogFragment = new simpleDialogFragment();
//        dialogFragment.show((MainActivity.this).getSupportFragmentManager(),"Image Dialog");
//    }

    public void simpleDialog(String s) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Galgeleg")
                .setMessage(s)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                });
                /*.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });*/


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}



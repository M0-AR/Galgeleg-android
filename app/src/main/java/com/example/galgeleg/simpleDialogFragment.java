package com.example.galgeleg;



import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

class simpleDialogFragment extends AppCompatDialogFragment { // Todo not working
 /*   @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Galgeleg")
                .setMessage(R.string.dialog_question)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }*/


/*
    TextView textView;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_layout, null);

        Bundle bundle = getArguments();
        String imageLink = bundle.getString("TEXT","");

        textView = (TextView) v.findViewById(R.id.username);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        return builder.create();
    }*/
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {


    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle("Galgeleg")
            .setMessage("This is a Dialog")
            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
    return builder.create();
}


}


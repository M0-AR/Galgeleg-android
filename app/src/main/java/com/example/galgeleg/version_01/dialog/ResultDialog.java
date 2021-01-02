package com.example.galgeleg.version_01.dialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.galgeleg.version_01.activity.ResultActivity;
import com.example.galgeleg.version_01.item.*;

import static com.example.galgeleg.version_01.Constants.*;

public class ResultDialog extends AppCompatDialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        final ResultItem resultItem = (ResultItem) bundle.getSerializable(OBJECT);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Galgeleg")
                .setMessage(resultItem.getResultMessage())
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getContext(), ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(OBJECT, resultItem);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
        return builder.create();
    }
}

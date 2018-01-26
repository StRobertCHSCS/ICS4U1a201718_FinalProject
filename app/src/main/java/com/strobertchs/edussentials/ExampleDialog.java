package com.strobertchs.edussentials;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Ernest on 2018-01-25.
 */

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editTextMark;
    private EditText editTextWeight;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater2 = getActivity().getLayoutInflater();
        View view = inflater2.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Mark")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });w
        editTextMark = view.findViewById(R.id.edit_markinput);
        editTextWeight = view.findViewById(R.id.edit_weightinput);

        return builder.create();
    }
}

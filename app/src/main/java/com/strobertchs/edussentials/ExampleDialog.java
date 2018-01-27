package com.strobertchs.edussentials;

import android.app.Dialog;
import android.content.Context;
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
    private EditText editTextDesired;
    private ExampleDialogListener listener;

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
                        String mark = editTextMark.getText().toString();
                        String weight = editTextWeight.getText().toString();
                        String grade = editTextDesired.getText().toString();
                        listener.applyTexts(mark, weight,grade);
                    }
                });
        editTextMark = view.findViewById(R.id.edit_markinput);
        editTextWeight = view.findViewById(R.id.edit_weightinput);
        editTextDesired = view.findViewById(R.id.edit_desiredgrade);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String mark, String weight,String grade);
    }
}

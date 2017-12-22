package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Vallyath on 2017-12-21.
 */

public class ContinueQuest extends DialogFragment {

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.continuequest, null);

        Button continueBtn = (Button) dialogView.findViewById(R.id.ContinueGame);
        Button newGameBtn = (Button) dialogView.findViewById(R.id.NewGame);
        Button exitBtn = (Button) dialogView.findViewById(R.id.Exit);
        TextView continueQuestion = (TextView) dialogView.findViewById(R.id.Question);

        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playGame = new Intent(view.getContext(), QuestionActivity.class);
                startActivity(playGame);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }
}

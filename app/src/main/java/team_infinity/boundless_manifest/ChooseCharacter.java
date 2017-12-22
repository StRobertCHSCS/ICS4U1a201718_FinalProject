package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.util.Set;

/**
 * Created by Acer on 2017-12-22.
 */

public class ChooseCharacter extends DialogFragment
{
    public Dialog onCreateDialog(Bundle saved)
    {
        //the builder to show the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View diaView = inflater.inflate(R.layout.popup_choose, null);

        //get the table from the view
        TableLayout table = (TableLayout) diaView.findViewById(R.id.tableLayout_heros);

        //get the set of all available characters
        Set<Integer> keySet = GlobalAttributes.characters.keySet();
        int numCharacters = keySet.size();

        //the characters that can be selected
        ImageButton[] buttons = new ImageButton[numCharacters];
        //counter for the loop below
        int ct = 0;

        //get all the sprites of characters
        for(Integer i : keySet)
        {
            Character chara = GlobalAttributes.characters.get(i);
            buttons[ct] = new ImageButton(getContext());

            //the id is already put in the object's characterSprite
            buttons[ct].setImageResource(chara.characterSprite);

            //give the button the event handler
            buttons[ct].setOnClickListener(chara.eventHandle);

            ct++;
        }

        /*
        add the code for putting character buttons to TableLayout here
         */

        //create and return with built dialog
        builder.setView(diaView).setMessage("");
        return builder.create();
    }
}

package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Set;

/**
 * Created by Acer on 2017-12-22.
 */

public class ChooseCharacter extends android.app.DialogFragment
{
    /**
     * static factory method
     * @return a new instance of ChooseCharacter
     */
    static ChooseCharacter newInstance()
    {
        ChooseCharacter c = new ChooseCharacter();

        //give the instance argument(there is nothing for now)
        Bundle args = new Bundle();
        c.setArguments(args);

        return c;
    }

    public void onCreate(Bundle saved)
    {
        //set the style of dialog
        super.onCreate(saved);
        setStyle(DialogFragment.STYLE_NO_FRAME, 0);
    }

    /**
     * sets up the DialogFragment
     * @param diaView the view created by inflater
     */
    private void setup(View diaView)
    {
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
            //create a ImageButton and give it a theme
            buttons[ct] = new ImageButton(getContext(), null, R.style.characterButtonTheme);

            //the id is already put in the object's characterSprite
            buttons[ct].setImageResource(chara.characterSprite);

            //give the button the event handler
            buttons[ct].setOnClickListener(chara.eventHandle);

            ct++;
        }

        /*
        add the code for putting character buttons to TableLayout here
         */

        TableRow row = (TableRow)diaView.findViewById(R.id.tableRow_heros_1);
        //counter for the following loop
        int ctt = 0;
        for(ImageButton b: buttons)
        {
            row.addView(b, new TableRow.LayoutParams(ctt));
            ctt++;
        }

        Log.d("tag", "ChooseCharacter.setup() finished");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle saved)
    {
        Log.d("tag", "ChooseCharacter.onCreateView() called");

        View v = inflater.inflate(R.layout.popup_choose, vg);
        //setup the widgets in the dialog
        this.setup(v);

        return v;
    }

    /*
    public Dialog onCreateDialog(Bundle saved)
    {
        //the builder to show the dialog
        //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

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

        TableRow row = (TableRow)diaView.findViewById(R.id.tableRow_heros_1);
        //counter for the following loop
        int ctt = 0;
        for(ImageButton b: buttons)
        {
            row.addView(b, new TableRow.LayoutParams(ctt));
            ctt++;
        }

        //create and return with built dialog
        //builder.setView(diaView).setMessage("");
        //return builder.create();

        return diaView;
    }
    */
}

package team_infinity.boundless_manifest;

import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import java.util.*;

@Deprecated
public class OnModeClickListener implements View.OnClickListener
{
    MainMenuActivity parent;

    public OnModeClickListener(MainMenuActivity m)
    {
        this.parent = m;
    }

    @Override
    public void onClick(View v)
    {
        //fetch the root layout from the main activity(or the designated activity)
        ConstraintLayout mainlayout = (ConstraintLayout) parent.findViewById(R.id.mainMenu_rootLayout);

        //setup the layout inflater
        LayoutInflater inflater = (LayoutInflater) parent.getSystemService(parent.LAYOUT_INFLATER_SERVICE);
        //create a view by inflating from inflater
        View popupView = inflater.inflate(R.layout.popup_choose, null);

        //get the table from the view
        //TableLayout table = (TableLayout) popupView.findViewById(R.id.tableLayout_heros);

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
            //buttons[ct] = new ImageButton();

            ct++;
        }


        //table.addView();

        //settings of popup window
        int width = 250;
        int height = 450;
        boolean focusable = true;
        PopupWindow pop = new PopupWindow(popupView, width, height, focusable);

        //show the popup window
        pop.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);
    }
}

package team_infinity.boundless_manifest;

import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by Acer on 2017-12-21.
 */

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

        //settings of popup window
        int width = 250;
        int height = 450;
        boolean focusable = true;
        PopupWindow pop = new PopupWindow(popupView, width, height, focusable);

        //show the popup window
        pop.showAtLocation(mainlayout, Gravity.CENTER, 0, 0);
    }
}

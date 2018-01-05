package team_infinity.boundless_manifest;

import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

/**
 * Created by Acer on 2018-01-05.
 */

public class OnModeClickListener2 implements View.OnClickListener
{
    MainMenuActivity parent;

    public OnModeClickListener2(MainMenuActivity m)
    {
        this.parent = m;
    }

    @Override
    public void onClick(View v)
    {
        //print to log
        Log.d("tag", "playGame.onClickListener.handle() called");
        //access FragmantTransaction from the activity
        FragmentTransaction ft = parent.getFragmentManager().beginTransaction();

        //create and show the popup
        android.app.DialogFragment choose = ChooseCharacter.newInstance();
        choose.show(ft, "choose");
    }
}

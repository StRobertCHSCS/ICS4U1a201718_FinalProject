package team_infinity.boundless_manifest;

import android.content.Intent;
import android.view.View;

/**
 * Created by Acer on 2018-01-27.
 */

public class ReturnButtonListener implements View.OnClickListener
{
    FinishActivity parent;

    /**
     * default constructor
     * @param fn the parent FinishActivity that owns this listener
     */
    public ReturnButtonListener(FinishActivity fn)
    {
        this.parent = fn;
    }

    @Override
    public void onClick(View v)
    {
        //reset
        GlobalAttributes.currentScore = -1;

        //end the finish activity
        parent.finish();
    }
}

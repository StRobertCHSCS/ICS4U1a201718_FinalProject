package team_infinity.boundless_manifest;

import android.content.Intent;
import android.util.Log;
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
        Log.d("qst", "ReturnButtonListener.onClick(): called, values " + GlobalAttributes.sessionAttributes.getKnowledge() + " " + GlobalAttributes.sessionAttributes.getThinking() + " " + GlobalAttributes.sessionAttributes.getUnderstanding());
        GlobalAttributes.knowledgeAtt += GlobalAttributes.sessionAttributes.getKnowledge();
        GlobalAttributes.thinkingAtt += GlobalAttributes.sessionAttributes.getThinking();
        GlobalAttributes.understandingAtt += GlobalAttributes.sessionAttributes.getUnderstanding();

        //reset
        GlobalAttributes.currentScore = -1;
        GlobalAttributes.sessionAttributes = null;

        //end the finish activity
        parent.finish();
    }
}

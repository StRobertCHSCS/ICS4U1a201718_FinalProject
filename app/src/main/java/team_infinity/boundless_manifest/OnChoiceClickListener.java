package team_infinity.boundless_manifest;

import android.view.View;

/**
 * Created by Acer on 2018-01-08.
 * implementation of OnClickListener
 * plugged into choice buttons
 */
public class OnChoiceClickListener implements View.OnClickListener
{
    QuestionActivity qa;
    int index;

    public OnChoiceClickListener(QuestionActivity q, int i)
    {
        this.qa = q;
        this.index = i;
    }

    @Override
    public void onClick(View v)
    {
        qa.answerClicked(this.index);
    }
}

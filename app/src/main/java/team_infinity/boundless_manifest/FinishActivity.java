package team_infinity.boundless_manifest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Acer on 2018-01-27.
 * the java class rendering the finish screen
 */
public class FinishActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceStates)
    {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.screen_finish);

        //score text
        TextView score = (TextView)findViewById(R.id.textView_score);
        score.setText("Score: " + GlobalAttributes.currentScore + "/5");

        /*
        you can access the session attributes by using GlobalAttributes.sessionAttributes
        and access it's value
         */

        //button to return to main screen
        Button buttonReturn = (Button) findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new ReturnButtonListener(this));
    }
}

package team_infinity.boundless_manifest;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainMenuActivity extends AppCompatActivity
{
    ImageButton mode;
    ImageButton playGame;
    private PopupWindow pop1;
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    FragmentManager statsFm = getSupportFragmentManager();
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //added for testing, since app crashes
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main_menu);

        final Context context = this;

        //the username at the top right
        TextView un = (TextView)findViewById(R.id.textView_usrnam);
        un.setText("Hello, " + android.os.Build.MODEL + "!");

        //the 'play' button
        playGame = (ImageButton) findViewById(R.id.playButton);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent openTutorial = new Intent(getApplicationContext(), TutorialSlides.class);
            startActivity(openTutorial);
            }
        });

        //the 'mode' button
        mode = (ImageButton) findViewById(R.id.imageButton_mode);
        mode.setOnClickListener(new OnModeClickListener2(this));

        //for testing purposes
        //this is the compass image button at the downleft corner
        ImageButton stats = (ImageButton) findViewById(R.id.statsButton);
        stats.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StatisticsPopUp statsPop = new StatisticsPopUp();
                statsPop.show(statsFm, "Statistics Pop-up");
                /*
                //for test purpose
                Log.d("qst", "MainMenuActivity.ib.OnClickListener.OnClick(): called");
                GlobalAttributes.questionGetter2.getQuestion(4274997763828313469l);
                */
            }
        });

        /*
        ImageButton calendar = (ImageButton)findViewById(R.id.imageButton_calendar);
        calendar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View views){
                Intent openCalendar = new Intent(views.getContext(), Calendar.class);
                startActivity(openCalendar);
            }
                                    });
                                    */

        //db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user_info").build(); code is no longer working

    }
}

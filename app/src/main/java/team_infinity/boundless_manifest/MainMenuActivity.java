package team_infinity.boundless_manifest;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.media.Image;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class MainMenuActivity extends AppCompatActivity
{
    ImageButton mode;
    ImageButton playGame;
    private PopupWindow pop1;
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = getFragmentManager().beginTransaction();
    AppDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Context context = this;

        //the 'play' button
        playGame = (ImageButton) findViewById(R.id.playButton);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContinueQuest continueQ = new ContinueQuest();
                continueQ.show(fm, "First Pop-up");
            }
        });

        //the 'mode' button
        mode = (ImageButton) findViewById(R.id.imageButton_mode);
        mode.setOnClickListener(new OnModeClickListener2(this));

        //for testing purposes
        //this is the compass image button at the downleft corner
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //for test purpose
                Log.d("qst", "MainMenuActivity.ib.OnClickListener.OnClick(): called");
                GlobalAttributes.questionGetter2.getQuestion(4274997763828313469l);
            }
        });

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "user_info").build();
    }
}

package team_infinity.boundless_manifest;

import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Context context = this;

        playGame = (ImageButton) findViewById(R.id.playButton);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContinueQuest continueQ = new ContinueQuest();
                continueQ.show(fm, "First Pop-up");

                Log.d("tag", "playGame.onClickListener.handle() called");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                android.app.DialogFragment choose = ChooseCharacter.newInstance();
                choose.show(ft, "apa");
            }
        });

        mode = (ImageButton) findViewById(R.id.imageButton_mode);
        mode.setOnClickListener(new OnModeClickListener(this));

    }
}

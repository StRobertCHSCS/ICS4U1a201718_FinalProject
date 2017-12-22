package team_infinity.boundless_manifest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainMenuActivity extends AppCompatActivity {

    ImageButton playGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Context context = this;
        playGame = (ImageButton) findViewById(R.id.playButton);
        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContinueQuest newQuest = new ContinueQuest();
                newQuest.setContext(context);
                newQuest.show(getFragmentManager(), "1");
            }
        });
    }
}

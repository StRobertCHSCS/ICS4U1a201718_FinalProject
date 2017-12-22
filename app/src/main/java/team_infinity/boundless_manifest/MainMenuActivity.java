package team_infinity.boundless_manifest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class MainMenuActivity extends AppCompatActivity
{
    ImageButton mode;
    private PopupWindow pop1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mode = (ImageButton) findViewById(R.id.imageButton_mode);
        mode.setOnClickListener(new OnModeClickListener(this));
    }
}

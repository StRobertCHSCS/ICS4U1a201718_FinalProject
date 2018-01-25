package com.strobertchs.edussentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AverageCalculator extends AppCompatActivity {
    private TextView textviewGradeinput;
    private TextView textviewWeightFactor;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        textviewGradeinput = (TextView) findViewById(R.id.textview_gradeinput);
        textviewWeightFactor = (TextView) findViewById(R.id.textview_weightfactor);
        button = (Button) findViewById(R.id.dialogbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog(){

    }
}

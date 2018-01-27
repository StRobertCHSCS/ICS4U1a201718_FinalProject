package com.strobertchs.edussentials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AverageCalculator extends AppCompatActivity implements ExampleDialog.ExampleDialogListener{
    private TextView textviewMarkinput;
    private TextView textviewWeightFactor;
    private Button button;
    private TextView textviewGrade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        textviewMarkinput = (TextView) findViewById(R.id.textview_markinput);
        textviewWeightFactor = (TextView) findViewById(R.id.textview_weightfactor);
        textviewGrade = (TextView) findViewById(R.id.TotalMarkID);
        button = (Button) findViewById(R.id.dialogbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }
    public void openDialog(){
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");

    }

    @Override
    public void applyTexts(String mark, String weight) {
        textviewMarkinput.setText(mark);
        textviewWeightFactor.setText(weight);
    }

}

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
    private TextView textviewDesiredGrade;
    private TextView textviewReqMark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        textviewMarkinput = (TextView) findViewById(R.id.textview_markinput);
        textviewWeightFactor = (TextView) findViewById(R.id.textview_weightfactor);
        textviewDesiredGrade = (TextView) findViewById(R.id.textview_desiregrade);
        textviewReqMark = (TextView) findViewById(R.id.textview_markneeded);
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
    public void applyTexts(String mark, String weight, String grade) {
        textviewMarkinput.setText(mark);
        textviewWeightFactor.setText(weight);
        textviewDesiredGrade.setText(grade);
        double mymark = Double.parseDouble(textviewMarkinput.getText().toString());
        double myweight = Double.parseDouble(textviewWeightFactor.getText().toString());
        double desiredmark = Double.parseDouble(textviewDesiredGrade.getText().toString());
        double value1 = mymark * (1-myweight);
        double value2 = desiredmark - value1;
        double markneeded = value2/(myweight);
        String markneeded_string = String.valueOf(markneeded);
        textviewReqMark.setText(markneeded_string);
    }


}

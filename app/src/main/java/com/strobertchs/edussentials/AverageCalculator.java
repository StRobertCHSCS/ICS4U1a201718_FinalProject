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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        textviewMarkinput = (TextView) findViewById(R.id.textview_markinput);
        textviewWeightFactor = (TextView) findViewById(R.id.textview_weightfactor);
        textviewDesiredGrade = (TextView) findViewById(R.id.textview_desiregrade);
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
    }

    public double getStringMarkInput(){
        String markinput = textviewMarkinput.getText().toString();
        double double_markinput = Double.parseDouble(markinput);
        return double_markinput;
    }

    public double getWeightFactor(){
        String weightfactor = textviewWeightFactor.getText().toString();
        double double_weightfactor = Double.parseDouble(weightfactor);
        return double_weightfactor;
    }

    public double getDesiredGrade(){
        String desiredgrade = textviewDesiredGrade.getText().toString();
        double double_desiredgrade = Double.parseDouble(desiredgrade);
        return double_desiredgrade;
    }


}

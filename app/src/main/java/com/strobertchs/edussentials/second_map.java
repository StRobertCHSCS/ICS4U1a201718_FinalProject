package com.strobertchs.edussentials;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class second_map extends AppCompatActivity {

    ImageView imageView;
    Matrix matrix = new Matrix();
    Float scale = 1f;
    ScaleGestureDetector SGD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        imageView = findViewById(R.id.imageView);
        SGD = new ScaleGestureDetector(this, new ScaleListener());

    }

    class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5f));
            matrix.setScale(scale, scale);
            imageView.setImageMatrix(matrix);
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        SGD.onTouchEvent(event);
        return true;
    }
}

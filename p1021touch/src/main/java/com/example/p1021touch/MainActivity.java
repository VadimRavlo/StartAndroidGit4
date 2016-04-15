package com.example.p1021touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    TextView textView;
    float x;
    float y;
    String sDown;
    String sMove;
    String sUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setOnTouchListener(this);
        setContentView(textView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = motionEvent.getX();
        y = motionEvent.getY();

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                sDown = "Down: " + x + "," + y;
                sMove = "";
                sUp = "";
                break;
            case MotionEvent.ACTION_MOVE:
                sMove = "Move: " + x + "," + y;
                break;
            case MotionEvent.ACTION_UP:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                break;
            case MotionEvent.ACTION_CANCEL:
                sMove = "";
                sUp = "Up: " + x + "," + y;
                break;
        }
        textView.setText(sDown + "\n" + sMove + "\n" + sUp);
        return true;
    }
}

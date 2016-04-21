package com.example.p1031multitouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    StringBuilder stringBuilder = new StringBuilder();
    TextView textView;
    int upPI;
    int downPI;
    boolean inTouch = false;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        textView.setTextSize(15);
        textView.setOnTouchListener(this);
        setContentView(textView);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMask = motionEvent.getActionMasked();
        int pointerIndex = motionEvent.getActionIndex();
        int pointerCount = motionEvent.getPointerCount();

        switch (actionMask){
            case MotionEvent.ACTION_DOWN:
                inTouch = true;
            case MotionEvent.ACTION_POINTER_DOWN:
                downPI = pointerIndex;
                break;
            case MotionEvent.ACTION_UP:
                inTouch = false;
                stringBuilder.setLength(0);
            case MotionEvent.ACTION_POINTER_UP:
                upPI = pointerIndex;
                break;
            case MotionEvent.ACTION_MOVE:
                stringBuilder.setLength(0);

                for (int i = 0; i < 10; i++) {
                    stringBuilder.append("Index = " + i);
                    if (i<pointerCount){
                        stringBuilder.append(", ID = " + motionEvent.getPointerId(i));
                        stringBuilder.append(", X = " + motionEvent.getX(i));
                        stringBuilder.append(", Y = " + motionEvent.getY(i));
                    } else {
                        stringBuilder.append(", ID = ");
                        stringBuilder.append(", X = ");
                        stringBuilder.append(", Y = ");
                    }
                    stringBuilder.append("\r\n");
                }
                break;
        }
        result = "down: " + downPI + "\n" + "up: " + upPI + "\n";
        if (inTouch){
            result += "pointerCount = " + pointerCount + "\n" + stringBuilder.toString();
        }
        textView.setText(result);

        return true;
    }
}

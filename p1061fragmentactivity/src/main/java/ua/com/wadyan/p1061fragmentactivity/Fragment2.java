package ua.com.wadyan.p1061fragmentactivity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by administrator on 24.08.2016.
 */

public class Fragment2 extends Fragment implements View.OnClickListener{

    interface OnSomeEventListener{
        void someEvent(String s);
    }

    OnSomeEventListener someEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(Constants.LOG_TAG, "onAttach");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(Constants.LOG_TAG, "onCreate");

        MainActivity activity = (MainActivity) getActivity();
        try {
            someEventListener = (OnSomeEventListener) activity;
        } catch (ClassCastException e){
//            throw new ClassCastException(context.toString() + " must implement onSomeEventListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2, null);

        Button btnLog = (Button) v.findViewById(R.id.btn_log);
        btnLog.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        Log.d(Constants.LOG_TAG, "onClick Fragment2");
        someEventListener.someEvent("Test text to Fragment1");
    }
}

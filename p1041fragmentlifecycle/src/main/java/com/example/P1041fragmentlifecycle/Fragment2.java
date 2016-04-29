package com.example.P1041fragmentlifecycle;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Vadim on 22.08.2016.
 */

public class Fragment2 extends Fragment {
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(Constnants.LOG_TAG, "Fragment2 onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Constnants.LOG_TAG, "Fragment2 onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(Constnants.LOG_TAG, "Fragment2 onCreateView");
        return inflater.inflate(R.layout.fragment2, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(Constnants.LOG_TAG, "Fragment2 onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(Constnants.LOG_TAG, "Fragment2 onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(Constnants.LOG_TAG, "Ftagment2 onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(Constnants.LOG_TAG, "Fragment2 onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(Constnants.LOG_TAG, "Fragment2 onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(Constnants.LOG_TAG, "Fragment2 onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(Constnants.LOG_TAG, "Fragment2 onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(Constnants.LOG_TAG, "Fragment2 onDetach");
    }

}

package ua.com.wadyan.p1061fragmentactivity;

import android.app.Fragment;
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

public class Fragment1 extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, null);

        Button btnLog = (Button) v.findViewById(R.id.btn_log);
        btnLog.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Button btnActivity = (Button) getActivity().findViewById(R.id.btn_find);
        btnActivity.setText("Access from Fragment1");
    }
}

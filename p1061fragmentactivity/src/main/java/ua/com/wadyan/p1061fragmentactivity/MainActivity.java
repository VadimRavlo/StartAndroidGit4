package ua.com.wadyan.p1061fragmentactivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment2.OnSomeEventListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment2 = new Fragment2();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment2, fragment2);
        fragmentTransaction.commit();
    }

    public void buttonOnClick(View v){
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);
        TextView tvFragment1 = (TextView) fragment1.getView().findViewById(R.id.tv_info);
        tvFragment1.setText("Access to Fragment1 from Activity");

        Fragment fragment2 = getFragmentManager().findFragmentById(R.id.fragment2);
        TextView tvFragment2 = (TextView) fragment2.getView().findViewById(R.id.tv_info);
        tvFragment2.setText("Access to Fragment2 from Activity");
    }

    @Override
    public void someEvent(String s) {
        Fragment fragment1 = getFragmentManager().findFragmentById(R.id.fragment1);
        TextView tvFragment1 = (TextView) fragment1.getView().findViewById(R.id.tv_info);
        tvFragment1.setText("Text from Fragment2: " + s);
    }
}

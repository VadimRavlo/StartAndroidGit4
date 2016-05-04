package com.example.p1051fragmentdynamic;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    FragmentTransaction fragmentTransaction;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

        checkBox = (CheckBox) findViewById(R.id.checkbox_stack);
    }

    public void onClick(View v){
        fragmentTransaction = getFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.btn_add:
                fragmentTransaction.add(R.id.fragment_container, fragment1);
                break;
            case R.id.btn_remove:
                fragmentTransaction.remove(fragment1);
                fragmentTransaction.remove(fragment2);
                break;
            case R.id.btn_replace:
                fragmentTransaction.replace(R.id.fragment_container, fragment2);
                break;
            default:
                break;
        }
        if (checkBox.isChecked()) fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}

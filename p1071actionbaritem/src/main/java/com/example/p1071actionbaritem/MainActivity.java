package com.example.p1071actionbaritem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Wadyan the best");
        getSupportActionBar().setSubtitle("Helo man");
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Log.d("myLogs", "Item1 selected");
                break;
            case R.id.item2:
                Log.d("myLogs", "Item2 selected");
                break;
            case R.id.item3:
                Log.d("myLogs", "Item3 selected");
                break;
            case R.id.item4:
                Log.d("myLogs", "Item4 selected");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

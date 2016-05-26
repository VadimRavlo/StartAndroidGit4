package com.example.p1081actionbarnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by administrator on 24.08.2016.
 */
public class PageFragment extends Fragment {

    int pageNumber;
    int backgroundColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(Constants.ARGUMENT_PAGE_NUMBER);
        Random random = new Random();
        backgroundColor = Color.argb(40, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);
        TextView tvPage = (TextView) view.findViewById(R.id.tv_page);
        tvPage.setText("Page " + pageNumber);
        tvPage.setBackgroundColor(backgroundColor);
        return view;
    }
}

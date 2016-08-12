package com.armistic.myapplication.myphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.armistic.myapplication.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import java.util.ArrayList;

/**
 * Created by jibieta on 11-08-16.
 */
public class MyPhotosActivity extends AppCompatActivity {

    private ArrayList<Photo> items;
    private Adapter adapter;
    private GridView gridView;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Iconify.with(new FontAwesomeModule());
        setContentView(R.layout.activity_my_photos);


        items = new ArrayList<Photo>();

        for (int i = 0; i < 5; i++) {
            items.add(new Photo("aa"));
        }

        adapter = new Adapter(this, items);
        gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(adapter);


    }
}

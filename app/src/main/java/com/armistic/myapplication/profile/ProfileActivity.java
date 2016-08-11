package com.armistic.myapplication.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.armistic.myapplication.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * Created by jibieta on 11-08-16.
 */
public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Iconify.with(new FontAwesomeModule());

        setContentView(R.layout.activity_profile);


    }
}

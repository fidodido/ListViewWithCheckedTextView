package com.armistic.myapplication.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.armistic.myapplication.R;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.widget.IconTextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jibieta on 11-08-16.
 */
public class ProfileActivity extends AppCompatActivity {

    private IconTextView quoteEdit;
    private TextView quoteText;
    private TextView idProfileDetail;
    private IconTextView idProfileDetailIcon;
    private IconTextView cameraIcon;
    private CircleImageView imageProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Iconify.with(new FontAwesomeModule());
        setContentView(R.layout.activity_profile);

        quoteEdit = (IconTextView) findViewById(R.id.quoteEdit);
        quoteText = (TextView) findViewById(R.id.quoteText);
        idProfileDetail = (TextView) findViewById(R.id.idProfileDetail);
        idProfileDetailIcon = (IconTextView) findViewById(R.id.idProfileDetailIcon);
        cameraIcon = (IconTextView) findViewById(R.id.cameraIcon);
        imageProfile = (CircleImageView) findViewById(R.id.profile_image);

        quoteEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditQuote();
            }
        });

        quoteText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditQuote();
            }
        });

        idProfileDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditProfile();
            }
        });

        idProfileDetailIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditProfile();
            }
        });

        cameraIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditPictures();
            }
        });

        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickEditPictures();
            }
        });

    }

    private void onClickEditQuote() {
        Toast.makeText(ProfileActivity.this, "Edit my quote profile.", Toast.LENGTH_SHORT).show();
    }

    private void onClickEditProfile() {
        Toast.makeText(ProfileActivity.this, "Edit my details profile.", Toast.LENGTH_SHORT).show();
    }

    private void onClickEditPictures() {
        Toast.makeText(ProfileActivity.this, "Edit my pictures", Toast.LENGTH_SHORT).show();
    }
}

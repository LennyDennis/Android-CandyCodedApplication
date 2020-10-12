package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView)findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // Launch the Google Maps Activity
    // ***

    public void createMapIntent(View view) {
        Uri uri = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        Intent googleMapsIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        googleMapsIntent.setPackage("com.google.android.apps.maps");
        if (googleMapsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(googleMapsIntent);
        }
    }
    // ***
    // Launch the Phone Activity
    // ***
    public void createPhoneIntent(View view){
        Uri uri = Uri.parse("tel:0123456789");
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(uri);
        startActivity(phoneIntent);
    }
}

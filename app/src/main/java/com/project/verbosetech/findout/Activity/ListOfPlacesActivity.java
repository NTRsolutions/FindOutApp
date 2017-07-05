package com.project.verbosetech.findout.Activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;

import com.project.verbosetech.findout.Models.GridCardModel;
import com.project.verbosetech.findout.Models.Places;
import com.project.verbosetech.findout.Othes.Constants;
import com.project.verbosetech.findout.Othes.PlacesRecycleGrid;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by this pc on 07-06-17.
 */

public class ListOfPlacesActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    PlacesRecycleGrid adapter;
    RecyclerView recyclerView;
    List<Places> placesList;
    Toolbar toolbar;
    RatingBar ratingBar;
    String gymnames[] = {"Talwalker Gym", "Crunch and curves", "Parijat", "Goal"};
    String hotelnames[] = {"Hotel Silver Line", "Aloha Hotel", "Hotel Paradise"};
    String homedecor[] = {"Evershine Home Decor & Giftware", "Guru Home Decor"};
    String travelers[] = {"Shivam Tours and Travels", "Bombay Travels"};
    ArrayList<String> name;

    String inName, inNumber;
    int inImage;

    public static Intent getIntent(Context context, GridCardModel gridCardModel) {
        Intent intent = new Intent(context, ListOfPlacesActivity.class);
        intent.putExtra(Constants.DATA_NAME, gridCardModel.getName());
        intent.putExtra(Constants.DATA_NUMBER, gridCardModel.getNumber());
        intent.putExtra(Constants.DATA_IMAGE, gridCardModel.getImage());
        return intent;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_recycle_view);

        Intent intent = getIntent();
        inName = intent.getStringExtra(Constants.DATA_NAME);
        inNumber = intent.getStringExtra(Constants.DATA_NUMBER);
        inImage = intent.getIntExtra(Constants.DATA_IMAGE, 0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(inName);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.place_recycle_grid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getCards();
    }

    public void getCards() {
        placesList = new ArrayList<>();
        switch (inName) {
            case "Restaurant":
                name = new ArrayList<>(Arrays.asList(hotelnames));
                break;
            case "Gymnasium":
                name = new ArrayList<>(Arrays.asList(gymnames));
                break;
            case "Home Decor":
                name = new ArrayList<>(Arrays.asList(homedecor));
                break;
            case "Travelers":
                name = new ArrayList<>(Arrays.asList(travelers));
                break;
        }

        int l = Integer.parseInt(inNumber);
        for (int i = 0; i < l; i++)
            placesList.add(new Places(inImage, name.get(i), "104, Old Street, New delhi", "5.4 km"));

        adapter = new PlacesRecycleGrid(getApplicationContext(), placesList, new PlacesRecycleGrid.VenueAdapterClickCallbacks() {
            @Override
            public void onCardClick(String p) {

                startActivity(new Intent(ListOfPlacesActivity.this, DetailActivity.class));
            }

            @Override
            public void onShareClick(String p) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }

            @Override
            public void onCallClick(String p) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + p));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);

            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

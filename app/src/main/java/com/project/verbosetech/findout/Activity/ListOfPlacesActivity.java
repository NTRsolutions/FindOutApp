package com.project.verbosetech.findout.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;

import com.project.verbosetech.findout.Models.Places;
import com.project.verbosetech.findout.Othes.PlacesRecycleGrid;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
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


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_recycle_view);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Restaurants");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left_white_24dp);
        setSupportActionBar(toolbar);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        recyclerView=(RecyclerView)findViewById(R.id.place_recycle_grid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        getCards();
    }

    public void getCards(){

        placesList=new ArrayList<>();
        placesList.add(new Places("Hotel Silver Line","104, Old Street, New delhi","5.4 km"));
        placesList.add(new Places("Hotel Silver Line","104, Old Street, New delhi","5.4 km"));
        placesList.add(new Places("Hotel Silver Line","104, Old Street, New delhi","5.4 km"));
        adapter=new PlacesRecycleGrid(getApplicationContext(), placesList, new PlacesRecycleGrid.VenueAdapterClickCallbacks() {
            @Override
            public void onCardClick(String p) {

                startActivity(new Intent(ListOfPlacesActivity.this,DetailActivity.class));
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}

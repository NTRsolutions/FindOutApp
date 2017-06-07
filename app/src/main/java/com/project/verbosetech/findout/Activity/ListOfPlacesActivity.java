package com.project.verbosetech.findout.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.verbosetech.findout.Models.Places;
import com.project.verbosetech.findout.Othes.PlacesRecycleGrid;
import com.project.verbosetech.findout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 07-06-17.
 */

public class ListOfPlacesActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    PlacesRecycleGrid adapter;
    RecyclerView recyclerView;
    List<Places> placesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places_recycle_view);
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
        adapter=new PlacesRecycleGrid();
        recyclerView.setAdapter(adapter);
    }
}

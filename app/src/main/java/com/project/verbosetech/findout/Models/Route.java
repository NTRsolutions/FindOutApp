package com.project.verbosetech.findout.Models;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by this pc on 10-06-17.
 */

public class Route {
    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}

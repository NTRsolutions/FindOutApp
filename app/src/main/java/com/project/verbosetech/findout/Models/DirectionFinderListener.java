package com.project.verbosetech.findout.Models;

import java.util.List;

/**
 * Created by this pc on 10-06-17.
 */

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}

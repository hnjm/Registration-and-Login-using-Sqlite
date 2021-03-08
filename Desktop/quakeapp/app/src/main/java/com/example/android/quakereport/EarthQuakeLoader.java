package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

public class EarthQuakeLoader extends AsyncTaskLoader<List<EarthQuake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthQuakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public EarthQuakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        if (mUrl==null){
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<EarthQuake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}

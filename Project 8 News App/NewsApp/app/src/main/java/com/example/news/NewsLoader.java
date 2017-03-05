package com.example.news;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {

        URL u = null;
        try {
            u = new URL(mUrl);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return QueryUtils.fetchEarthquakeData(u);
    }
}

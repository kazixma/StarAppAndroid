package com.example.bestiize.firstapp;

import android.app.Application;
import android.util.Log;

import com.example.bestiize.firstapp.manager.StarManager;
import com.example.bestiize.firstapp.models.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bestiize on 9/6/2015.
 */
public class StarApplication  extends Application{
    private  StarManager starManager;
    @Override
    public void onCreate() {
        super.onCreate();
        List<Star> starList = new ArrayList();
        starManager =new StarManager(starList);
        starList.add(new Star("A","desA","http://www.bloggang.com/data/imaginer/picture/1368453259.jpg"));
        starList.add(new Star("B","desB","http://www.bloggang.com/data/imaginer/picture/1368454090.jpg"));
        starList.add(new Star("C", "desC", "http://www.bloggang.com/data/imaginer/picture/1368454663.jpg"));
        Log.d("StarApplication","onCreate ");


    }

    public StarManager getStarManager() {
        return starManager;
    }

    public void setStarManager(StarManager starManager) {
        this.starManager = starManager;
    }
}

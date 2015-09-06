package com.example.bestiize.firstapp.manager;

import com.example.bestiize.firstapp.models.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bestiize on 9/6/2015.
 */
public class StarManager {
    private List<Star> starList;
    public StarManager(List<Star> starList) {
        this.starList = starList;


    }

    public List<Star> getStarList() {
        return starList;
    }

    public void setStarList(List<Star> starList) {
        this.starList = starList;
    }
}

package com.example.bestiize.firstapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bestiize.firstapp.R;
import com.example.bestiize.firstapp.models.Star;

/**
 * Created by Bestiize on 9/6/2015.
 */
public class StarListItem extends RelativeLayout {
    private  TextView text;
    public StarListItem(Context context) {
        super(context);
        initView();
    }
    public void initView(){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.view_list_star,this);
        text = (TextView) view.findViewById(R.id.textview_star);


    }
    public void fill(Star starData){
        text.setText(starData.getName());


    }
}

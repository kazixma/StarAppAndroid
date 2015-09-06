package com.example.bestiize.firstapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bestiize.firstapp.R;
import com.example.bestiize.firstapp.models.Star;
import com.squareup.picasso.Picasso;

/**
 * Created by Bestiize on 9/6/2015.
 */
public class StarFragment extends Fragment {
    private String name;
    private String  description;
    private String url;
    private TextView text_name,text_des;
    private ImageView imageView;
    private View view;
    public StarFragment(Star star){
        this.name = star.getName();
        this.description = star.getDescription();
        this.url = star.getImageUrl();
        Log.d("StarFragment","URL : " + url);
        initView();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_star,container,false);
        imageView = (ImageView) view.findViewById(R.id.image);
        text_name = (TextView) view.findViewById(R.id.name);
        text_des = (TextView) view.findViewById(R.id.description);
        fill();
        return view;
    }

    public void initView(){
    //        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }
    public void fill(){
        text_name.setText(this.name);
        text_des.setText(this.description);
//        Picasso.with(getActivity()).load(this.url).resize(100,100).into(imageView);
        Glide.with(this).load(url).into(imageView);
    }

}

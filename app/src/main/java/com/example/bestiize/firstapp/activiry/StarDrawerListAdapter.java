package com.example.bestiize.firstapp.activiry;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bestiize.firstapp.StarApplication;
import com.example.bestiize.firstapp.view.StarListItem;

/**
 * Created by Bestiize on 9/6/2015.
 */
public class StarDrawerListAdapter extends BaseAdapter {
    private  StarApplication starApplication;
    private Context context;
    public StarDrawerListAdapter(Context context){
        this.starApplication = (StarApplication)context;
        this.context = context;


    }
    @Override
    public int getCount() {

        return starApplication.getStarManager().getStarList().size();
    }
    @Override
    public Object getItem(int position) {
        return starApplication.getStarManager().getStarList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        StarListItem item = createListItem(convertView);
        item.fill(starApplication.getStarManager().getStarList().get(position));

        return item;
    }

    public StarListItem createListItem(View convertView){

        if(convertView == null || !(convertView instanceof StarListItem)){
            return new StarListItem(this.context);
        }

        return (StarListItem)convertView;

    }


}

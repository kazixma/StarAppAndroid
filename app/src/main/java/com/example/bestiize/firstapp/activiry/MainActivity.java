package com.example.bestiize.firstapp.activiry;

import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bestiize.firstapp.R;
import com.example.bestiize.firstapp.StarApplication;
import com.example.bestiize.firstapp.fragments.StarFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private StarDrawerListAdapter starDrawerListAdapter;
    private StarFragment[] starFragment;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);
        starDrawerListAdapter  = new StarDrawerListAdapter(getApplicationContext());
        listView.setAdapter(starDrawerListAdapter);
        count = ((StarApplication)getApplicationContext()).getStarManager().getStarList().size();
        starFragment= new StarFragment[count];

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                beginFragmentTransaction(position);
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });

        for(int i =0 ;i<count; i++){
            starFragment[i] = new StarFragment(((StarApplication)getApplicationContext()).getStarManager().getStarList().get(i));

        }

        getSupportFragmentManager().beginTransaction().addToBackStack(starFragment.getClass().getName()).replace(R.id.content_frame, starFragment[0]).commit();
    }

    public void beginFragmentTransaction(int position){
        getSupportFragmentManager().beginTransaction().addToBackStack(starFragment.getClass().getName()).replace(R.id.content_frame, starFragment[position]).commit();
    }

    @Override
    public void onBackPressed() {

        if(!getSupportFragmentManager().beginTransaction().isEmpty()){
            getSupportFragmentManager().popBackStack();
        }
        super.onBackPressed();
    }
}

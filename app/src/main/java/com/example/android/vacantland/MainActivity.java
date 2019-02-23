package com.example.android.vacantland;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    //Integer[] mImageResourceId = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> imageResourceIdList = new ArrayList<Integer>();
        ArrayList<String> locationList = new ArrayList<String>();
        ArrayList<String> descList = new ArrayList<String>();

        imageResourceIdList.add(R.drawable.brochure);
        locationList.add("hello");
        descList.add("Amazing place");


        imageResourceIdList.add(R.drawable.sticker);
        locationList.add("hello");
        descList.add("Amazing place");

        imageResourceIdList.add(R.drawable.poster);
        locationList.add("hello");
        descList.add("Amazing place");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter1 = new RecyclerViewAdapter(this, imageResourceIdList, locationList, descList);
        recyclerView.setAdapter(adapter1);


        models = new ArrayList<>();
        models.add(new Model("Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model("Sticker", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model("Poster", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new Model("Namecard", "Business cards are cards bearing business information about a company or individual."));

        adapter = new Adapter(models,this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        //Integer[] imageResourceId = {R.drawable.brochure,R.drawable.sticker,R.drawable.poster,R.drawable.namecard};

        //mImageResourceId = imageResourceId;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                /*if (position < (adapter.getCount() -1) && position < (mImageResourceId.length - 1)) {

                    imageView.setImageResource(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    mImageResourceId[position],
                                    mImageResourceId[position + 1]
                            )
                    );
                }

                else {
                    imageView.setImageResource(mImageResourceId[mImageResourceId.length - 1]);
                }*/
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}

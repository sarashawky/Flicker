package com.example.android.flickr;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String image_titles[] = {
            "R18_4489",
            "Buizerd",
            "_MG_7157F_Heron",
            "Snowy Owl",
            "Fly past",
            "Gull over Hollow Pond",
            "Incoming",
            "Raspberry Pi Trailcam",
            "Eye-to-Eye: Choco Toucan (Ramphastos brevis)",
            "Two Colorful Macaws",
            "Carpe Diem",
            "Two Colorful Macaws",
            "Can't you see I'm busy",
            "Birds at Balatonf u00fcred",
            "Jay",
            "Jay",
            "Marsh Tit (Poecile palustris)",
            "CS-20181124-10",
            "CS-20181124-32",
            "CS-20181124-36"
    };

    private final String image_ids[] = {
            "https://farm5.staticflickr.com//4806//45421765694_ceb7d6d37b_b.jpg",
            "https://farm5.staticflickr.com//4835//46145461211_1a857dedf7_b.jpg",
            "https://farm5.staticflickr.com//4837//46145400621_816ca54622_b.jpg",
            "https://farm5.staticflickr.com//4827//46095068002_cd132fdf0b_b.jpg",
            "https://farm5.staticflickr.com//4834//31206370127_5f1258f5ae_b.jpg",
            "https://farm5.staticflickr.com//4872//44328763800_f5c5224f10_b.jpg",
            "https://farm5.staticflickr.com//4906//46095222142_322c3a1aff_b.jpg",
            "https://farm5.staticflickr.com//4868//45233723965_53eee1cf29_b.jpg",
            "https://farm5.staticflickr.com//4810//46095203652_c4042620a0_b.jpg",
            "https://farm5.staticflickr.com//4845//44328725800_47c3a12ab0_b.jpg",
            "https://farm5.staticflickr.com//4814//46145326691_6246260561_b.jpg",
            "https://farm5.staticflickr.com//4838//46095166672_40ba3449b6_b.jpg",
            "https://farm5.staticflickr.com//4823//46145299381_856d1cf2c6_b.jpg",
            "https://farm5.staticflickr.com//4844//44328664770_6bfd18d0c2_b.jpg",
            "https://farm5.staticflickr.com//4870//46145243511_ed5d166534_b.jpg",
            "https://farm5.staticflickr.com//4842//31206226797_07274354cf_b.jpg",
            "https://farm5.staticflickr.com//4881//45421537414_20532f7307_b.jpg",
            "https://farm5.staticflickr.com///4875//45233616435_6e24dce36b_b.jpg",
            "https://farm5.staticflickr.com//4902//45233614625_2994298e4c_b.jpg",
            "https://farm5.staticflickr.com//4810//45233613305_1668f4b403_b.jpg"

    };
    SwipeRefreshLayout swiper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        swiper= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Item> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), createLists,swiper);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Item> prepareData(){

        ArrayList<Item> theimage = new ArrayList<>();
        for(int i = 0; i< image_titles.length; i++){
            Item createList = new Item();
            createList.setImage_title(image_titles[i]);
            createList.setImage_id(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }

}


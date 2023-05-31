package com.mgdapps.easybrowser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    String titlearray[]={"Allrecipes","Food","The Kitchn","Epicurious","Bon Appétit","Simple Indian Recipes","Bawarchi", "Indian Food Forever"};
    String infoarray[]={"Find and share everyday cooking inspiration on Allrecipes. Discover recipes, cooks, videos, and how-tos based on the food you love and the friends you follow.","Food.com has a massive collection of recipes that are submitted, rated and reviewed by people who are passionate about food.","Inspiring cooks and nourishing homes through daily recipes, tips, kitchen design and shopping guides.","Since 1995, Epicurious has been the ultimate food resource for the home cook, with daily kitchen tips, fun cooking videos, and, oh yeah, over 33000 recipes.","Cook with Confidence. Enjoy your Food. Find recipes, search our encyclopedia of cooking tips and ingredients, watch food videos and more","Simple, Delicious, Healthy & Easy Home Made Indian Food Recipes. These Recipes Are Tried & Tested At Home","Largest collection of healthy Indian veg recipes and non-veg food - breakfast, snacks, soup, dessert and dinner. Recipes include South Indian, Punjabi and more","Indian Food Recipes, Indian Food Recepies, Indian Cooking, Indian Cuisines."};
    int imagearray[]={R.drawable.cooking_allrecipes,R.drawable.cooking_food,R.drawable.cooking_thekitchn,R.drawable.epicurious,R.drawable.cooking_bonappetie,R.drawable.cooking_indianrecipes,R.drawable.cooking_bawarchi,R.drawable.cooking_indianfoodforever};


    ListView lv_home_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lv_home_list=(ListView)findViewById(R.id.lv_home_list);

        homeadapter homeadapter=new homeadapter(getApplicationContext(),1);

        lv_home_list.setAdapter(homeadapter);
        lv_home_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                    {
                        Case("http://www.Allrecipes.com");
                        break;
                    }
                    case 1:
                    {
                        Case("http://www.food.com/");
                        break;
                    }
                    case 2:
                    {
                        Case("http://www.thekitchn.com/");
                        break;
                    }
                    case 3:
                    {
                        Case("http://www.epicurious.com/");
                        break;
                    }
                    case 4:
                    {
                        Case("http://www.Bonappetit.com");
                        break;
                    }
                    case 5:
                    {
                        Case("http://simpleindianrecipes.com/");
                        break;
                    }
                    case 6:
                    {
                        Case("http://www.bawarchi.com/");
                        break;
                    }
                    case 7:
                    {
                        Case("http://www.indianfoodforever.com/");
                        break;
                    }
                    default:
                    {

                    }
                }


            }
        });

  //      Allrecipes.com,http://www.food.com/http://www.thekitchn.com/,http://www.epicurious.com/, Bonappetit.com, http://simpleindianrecipes.com/,http://www.bawarchi.com/, http://www.indianfoodforever.com/
    }


    private String Case(String reg)
    {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }

    private class homeadapter extends ArrayAdapter
    {

        public homeadapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return imagearray.length;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            View row=layoutInflater.inflate(R.layout.list_row,parent,false);

            ImageView list_row_image=(ImageView)row.findViewById(R.id.list_row_image);
            TextView list_row_info=(TextView)row.findViewById(R.id.list_row_info);
            TextView list_row_title=(TextView)row.findViewById(R.id.list_row_title);


            list_row_image.setImageResource(imagearray[position]);
            list_row_info.setText(infoarray[position]);
            list_row_title.setText(titlearray[position]);

            return row;
        }
    }

}

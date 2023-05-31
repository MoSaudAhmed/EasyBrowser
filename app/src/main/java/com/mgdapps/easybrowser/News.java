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

public class News extends AppCompatActivity {

    ListView lv_news_list;

    int imagearray[] = {R.drawable.news_bbc,R.drawable.news_cnn,R.drawable.news_googlenews,R.drawable.news_indiatoday,R.drawable.news_ndtv,R.drawable.news_zeenews,R.drawable.news_geonews,R.drawable.news_euronews,R.drawable.news_aljazeer,R.drawable.news_skynews,R.drawable.news_abpnews,R.drawable.news_timesnow};
    String infoarray[] = {"Breaking news, sport, TV, radio and a whole lot more. The BBC informs, educates and entertains - wherever you are, whatever your age.","View the latest news and breaking news today, world, weather, entertainment, politics and health","Comprehensive, up-to-date news coverage, aggregated from sources all over the world by Google News.","Check out the latest news from India and around the world. Latest India news on Bollywood, Politics, Business, Cricket, Technology and Travel.","NDTV.com provides latest news from India and the world. Get today's news headlines from Business, Technology, Bollywood, Cricket, videos, photos, live news","National, regional, and world news from Zee Telefilms.","Geo TV provides latest news, breaking news, urdu news from pakistan, world, sports, cricket, business, politics, health. watch geo news on live.geo.tv.","Latest breaking news available as free video on demand. Stay informed of European and World news about economy, politics, diplomacy… with Euronews.","News, analysis from the Middle East & worldwide, multimedia & interactives, opinions, documentaries, podcasts, long reads and broadcast schedule.","Sky news delivers breaking news, headlines and top stories from business, politics, entertainment and more in the UK and worldwide.","ABP News · LIVE Home;  Live TV. LIVE: ABP NEWS TV.","Times Now delivers the latest news, headlines & live news updates from India, World, Politics, Business, Sports, Technology, Bollywood, Entertainment, Videos ..."};
    String titlearray[] = {"BBC","CNN","Google News","India Today","NDTV","Zee News","Geo News","Euronews","Al Jazeera","Sky News","ABP News","Times Now"};
//geoNews

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        lv_news_list = (ListView) findViewById(R.id.lv_news_list);

        lv_news_list.setAdapter(new newsadapter(getApplicationContext(), 0));

        lv_news_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.bbc.com/");
                        break;
                    }

                    case 1: {
                        Case("http://edition.cnn.com/");
                        break;
                    }
                    case 2: {
                        Case("https://news.google.co.in/");
                        break;
                    }

                    case 3: {
                        Case("http://indiatoday.intoday.in/");
                        break;
                    }
                    case 4: {
                        Case("http://www.ndtv.com/");
                        break;
                    }
                    case 5: {
                        Case("http://zeenews.india.com/");
                        break;
                    }
                    case 6: {
                        Case("https://www.geo.tv/");
                        break;
                    }
                    case 7:
                    {
                        Case("http://www.euronews.com/");
                        break;
                    }
                    case 8:
                    {
                        Case("http://www.aljazeera.com/");
                        break;
                    }
                    case 9:
                    {
                        Case("http://news.sky.com/");
                        break;
                    }
                    case 10:
                    {
                        Case("http://www.timesnow.tv/");
                        break;
                    }

                    default:
                    {

                    }
                }
            }
        });

    }


    private String Case(String reg) {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }


    private class newsadapter extends ArrayAdapter {

        public newsadapter(Context context, int resource) {
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

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.list_row, parent, false);

            ImageView list_row_image = (ImageView) row.findViewById(R.id.list_row_image);
            TextView list_row_info = (TextView) row.findViewById(R.id.list_row_info);
            TextView list_row_title = (TextView) row.findViewById(R.id.list_row_title);

            list_row_image.setImageResource(imagearray[position]);
            list_row_title.setText(titlearray[position]);
            list_row_info.setText(infoarray[position]);

            return row;
        }
    }
}

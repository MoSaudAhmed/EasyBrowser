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

public class Sports extends AppCompatActivity {

    ListView lv_sports_list;
    String titlearray[]={"ESPN", "ESPN Cricinfo","Yahoo Sports","Cricbuzz","Bleacher Report","CBS Sports","Sports Illustrated","NBC Sports","SB Nation","NDTV Sports","BBC Sports","Indian Premier League","International Cricket Council","FIFA- Football Organization"};
    String infoarray[]={"Visit ESPN to get up-to-the-minute sports news coverage, scores, highlights and commentary for cricket, rugby, football, F1, kabaddi and more.","ESPN Cricinfo provides the most comprehensive cricket coverage available including live ball-by-ball commentary, news, unparalleled statistics, quality editorial ...","All the latest Sports News, Scores, Fantasy Games.","Get live cricket scores, ball by ball commentary, schedules of International, Domestic &amp; IPL cricket matches along with latest news and ICC cricket rankings","Sports journalists and bloggers covering NFL, MLB, NBA, NHL, MMA, college football and basketball, NASCAR, fantasy sports and more. News, photos, mock ..","The FASTEST Scores, News, Live Videos and more! Get your scores and stats first; Lightning fast access to scores and stats; Stream live video of CBS Sports ...","Sports Illustrated is your daily destination for sports news and expert analysis including NFL, NBA, NHL, MLB, NASCAR, college basketball, college ...","NHL on NBC ... NASCAR on NBC Pod: Forde's Chase analytics ... Your home for the Premier League on NBC Sports. Top Headlines. Autopsy report","SB Nation is the fastest growing online sports media brand, consisting of national sports site SBNation.com and 300 individual team and sport sites ..","NDTV Sports is the ultimate destination for Sports fans from around the World. Get latest sports news and updates from Cricket, Tennis, Football, Formula One...","The home of BBC Sport online. Includes live sports coverage, breaking news, results, video, audio and analysis on Football, F1, Cricket, Rugby Union, Rugby and more...","The Indian Premier League is a professional Twenty20 cricket league in India contested during April and May of every year by franchise teams representing Indian cities.","live matches, scores, news, highlights, commentary, rankings, videos and fixtures from the International Cricket Council.","The official site of the international governing body of football with news, national associations, competitions, results, fixtures, development, organisation, world."};
    int imagearray[]={R.drawable.sports_espn,R.drawable.sports_espncricinfo,R.drawable.sports_yahoosports,R.drawable.sports_crizbuzz,R.drawable.sports_bleacher_report,R.drawable.sports_cbs,R.drawable.sports_sports_illustrated,R.drawable.sports_nbcsports,R.drawable.sports_sbnation,R.drawable.sports_ndtvsports,R.drawable.sports_bbcsports,R.drawable.sports_indian_premier_league,R.drawable.sports_international_cricket_council,R.drawable.sports_fifa};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        lv_sports_list=(ListView)findViewById(R.id.lv_sports_list);

        lv_sports_list.setAdapter(new sportsarray(getApplicationContext(),0));

        lv_sports_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    {
                        Case("http://www.espn.in/");
                        break;
                    }
                    case 1:
                    {
                        Case("http://www.espncricinfo.com/");
                        break;
                    }
                    case 2:
                    {
                        Case("https://in.news.yahoo.com/");
                        break;
                    }
                    case 3:
                    {
                        Case("http://www.cricbuzz.com/");
                        break;
                    }
                    case 4:
                    {
                        Case("http://bleacherreport.com/");
                        break;
                    }
                    case 5:
                    {
                        Case("http://www.cbssports.com/");
                        break;
                    }
                    case 6:
                    {
                        Case("http://www.si.com/");
                        break;
                    }
                    case 7:
                    {
                        Case("http://www.nbcsports.com/");
                        break;
                    }
                    case 8:
                    {
                        Case("http://www.sbnation.com/");
                        break;
                    }
                    case 9:
                    {
                        Case("http://sports.ndtv.com/");
                        break;
                    }
                    case 10:
                    {
                        Case("http://www.bbc.co.uk/sport");
                        break;
                    }
                    case 11:
                    {
                        Case("http://www.iplt20.com/");
                        break;
                    }
                    case 12:
                    {
                        Case("http://www.icc-cricket.com/");
                        break;
                    }
                    case 13:
                    {
                        Case("http://www.fifa.com/");
                        break;
                    }

                    default:
                    {

                    }
                }
            }
        });
    }

    //http://www.espn.in/,http://www.espncricinfo.com/, https://in.news.yahoo.com/,  http://www.cricbuzz.com/, http://www.bbc.com/, https://news.google.co.in/, http://indiatoday.intoday.in/news.html, http://www.ndtv.com/, http://zeenews.india.com/,

    private String Case(String reg)
    {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }


    private class sportsarray extends ArrayAdapter
    {

        public sportsarray(Context context, int resource) {
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

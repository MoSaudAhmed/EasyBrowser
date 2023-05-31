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

public class FreeMobileGames extends AppCompatActivity {

    ListView lv_mobilegames_list;

    ImageView list_row_image;
    TextView list_row_title, list_row_info;

    String titlearray[] = {"Play.Mob.Org", "Mobo Genie", "Apk4Fun", "ApkPure", "ApkReal", "Nine Games"};
    String infoarray[] = {"Download Tons of Games, Applications, Wallpapers, Live Wallpapers, Themes, Ringtones", "Download Android apps for FREE, Pokémon Go, Grand Theft Auto, Minecraft, TubeMate, Vidmate, WhatsApp Messenger, Xhubs, Facebook Messenger.", "Best android apps download new apps like whatsApp,line,hike games etc free here. Paid on google store but free on apk4fun.", "Download apk for Android with APKPure APK downloader. NoAds, Faster apk downloads and apk file update speed. Best of all, it's free.", "Your Premium Apk Games and Apk Apps Store to Download Android Mod Apk Hack and Mod Apk For Free with No Ads, we have unlimited modded apps ..", "Free Android games download. Thousands of top best Android games at 9Games! Play free games for Android mobile phone now!"};
    int imagesarray[] = {R.drawable.games_playmob, R.drawable.games_mobogenie, R.drawable.games_apkforfun, R.drawable.games_apkpure, R.drawable.games_apkreal, R.drawable.games_ninegames};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_mobile_games);

        lv_mobilegames_list = (ListView) findViewById(R.id.lv_mobilegames_list);

        gameadapter gameadapter = new gameadapter(getApplicationContext(), 0);

        lv_mobilegames_list.setAdapter(gameadapter);

        lv_mobilegames_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://play.mob.org/");
                        break;
                    }
                    case 1: {
                        Case("http://www.mobogenie.com/");
                        break;
                    }
                    case 2: {
                        Case("https://apkpure.com");
                        break;
                    }
                    case 3: {
                        Case("http://apkreal.com");
                        break;
                    }

                    case 4: {
                        Case("http://www.9game.com");
                        break;
                    }
                    case 5: {
                        Case("https://www.apk4fun.com");
                        break;
                    }
                    default: {

                    }
                }
            }
        });

        //http://play.mob.org/,http://www.mobogenie.com/,https://apkpure.com,http://apkreal.com/,http://www.9game.com/, https://www.apk4fun.com/
    }

    private String Case(String res) {

        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", res);
        startActivity(intent);

        return null;
    }

    private class gameadapter extends ArrayAdapter {


        public gameadapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public int getCount() {
            return imagesarray.length;
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

            list_row_image = (ImageView) row.findViewById(R.id.list_row_image);
            list_row_info = (TextView) row.findViewById(R.id.list_row_info);
            list_row_title = (TextView) row.findViewById(R.id.list_row_title);

            list_row_image.setImageResource(imagesarray[position]);
            list_row_info.setText(infoarray[position]);
            list_row_title.setText(titlearray[position]);

            return row;
        }
    }


}

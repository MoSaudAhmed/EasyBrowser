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

public class VideoSharing extends AppCompatActivity {

    ListView lv_videosharing_list;
    ImageView list_row_image;
    TextView list_row_title, list_row_info;


    int imagesarray[] = {R.drawable.video_dailymotion, R.drawable.video_viemo, R.drawable.video_veoh, R.drawable.video_metacafe, R.drawable.video_imdb};
    String titlearray[] = {"Dailymotion", "Vimeo", "Veoh", "Metacafe", "IMDB"};
    String infoarray[] = {"Find and watch recommended videos for you, staff picks, and popular content from the best creators and channels on Dailymotion.", "Join the web's most supportive community of creators and get high-quality tools for hosting, sharing, and streaming videos in gorgeous HD and 4K with no ads.", "Millions of online videos including free TV shows, movies, and music. Upload and share your videos on Veoh the video sharing network.", "One of the world's largest video sites, serving the best videos, funniest movies and clips.", "IMDb, the world's most popular and authoritative source for movie, TV and celebrity content."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_sharing);

        lv_videosharing_list = (ListView) findViewById(R.id.lv_videosharing_list);

        lv_videosharing_list.setAdapter(new listadapter(getApplicationContext(), 0));

        lv_videosharing_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                        @Override
                                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                            switch (position) {


                                                                case 0: {
                                                                    Case("http://www.dailymotion.com/in");
                                                                    break;
                                                                }
                                                                case 1: {
                                                                    Case("https://vimeo.com/");
                                                                    break;
                                                                }

                                                                case 2: {
                                                                    Case("http://www.veoh.com/");
                                                                    break;
                                                                }
                                                                case 3: {
                                                                    Case("http://www.metacafe.com/");
                                                                    break;
                                                                }
                                                                case 4: {
                                                                    Case("http://www.imdb.com/");
                                                                    break;
                                                                }

                                                                default: {

                                                                }
                                                            }

                                                        }
                                                    }

        );

    }

    private String Case(String row) {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", row);
        startActivity(intent);

        return null;
    }

    private class listadapter extends ArrayAdapter {
        Context context;
        int resource;

        public listadapter(Context context, int resource) {
            super(context, resource);
            this.context = context;


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
            list_row_title.setText(titlearray[position]);
            list_row_info.setText(infoarray[position]);


            return row;
        }
    }
}

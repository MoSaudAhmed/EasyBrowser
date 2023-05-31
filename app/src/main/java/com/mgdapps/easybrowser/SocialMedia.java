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

public class SocialMedia extends AppCompatActivity {

    ListView lv_social_list;
    ImageView list_row_image;
    TextView list_row_title, list_row_info;

    int imagesarray[] = {R.drawable.social_facebook_logo, R.drawable.social_twitter, R.drawable.social_linkedin, R.drawable.social_pinterest, R.drawable.social_google_, R.drawable.social_tumblr, R.drawable.social_instagram, R.drawable.social_reddit, R.drawable.social_qeep, R.drawable.social_vk, R.drawable.social_viemo, R.drawable.social_flickr};
    String titlearray[] = {"Facebook", "Twitter", "Linkedin", "Pinterest", "Google+", "Tumblr", "Instagram", "Reddit", "Qeep", "VK", "Vimeo", "Flickr"};
    String infoarray[] = {"Log into Facebook to start sharing and connecting with your friends, family, and people you know.", " Sign in now to check your notifications, join the conversation and catch up on Tweets from the people you follow.", "Manage your professional identity. Build and engage with your professional network. Access knowledge, insights and opportunities.", "A content sharing service that allows members to \"pin\" images, videos and other objects to their pinboard.", "Google+ is a place to discover amazing things and connect with passionate people.", "Post anything (from anywhere!), customize everything, and find and follow what you love.", "Instagram is a simple way to capture and share the world's moments. Follow your friends and family to see what they're up to, and discover accounts from all ...", "Reddit is a social news aggregation, web content rating, and discussion website. Reddit's registered community members can submit content, such as text posts or direct links.", "Get Qeep now to meet people, chat, make new friends, flirt or even find your next date! With more than 30 million users, maximum fun is guaranteed!", "VK is the largest European online social networking service, based in St. Petersburg. It is available in several languages, and is especially popular among Russian-speaking users.", "Join the web's most supportive community of creators and get high-quality tools for hosting, sharing, and streaming videos in gorgeous HD and 4K with no ads.", "Picture galleries available with social networking, chat, groups, and photo ratings."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        lv_social_list = (ListView) findViewById(R.id.lv_social_list);


        lv_social_list.setAdapter(new listadapter(getApplicationContext(), 0));
        lv_social_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.Facebook.com");
                        break;
                    }
                    case 1: {
                        Case("https://twitter.com/");
                        break;
                    }
                    case 2: {
                        Case("https://www.linkedin.com");
                        break;
                    }

                    case 3: {
                        Case("https://www.pinterest.com/");
                        break;
                    }

                    case 4: {
                        Case("https://plus.google.com/");
                        break;
                    }
                    case 5: {
                        Case("https://www.tumblr.com/");
                        break;
                    }
                    case 6: {
                        Case("https://www.instagram.com/");
                        break;
                    }
                    case 7: {
                        Case("https://www.reddit.com/");
                        break;
                    }
                    case 8: {
                        Case("http://qeep.mobi/xmps/homepage.do");
                        break;
                    }
                    case 9: {
                        Case("https://vk.com/");
                        break;
                    }
                    case 10: {
                        Case("https://vimeo.com/");
                        break;
                        
                    }
                    case 11: {
                        Case("https://www.flickr.com/");
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
        });

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

package com.mgdapps.easybrowser;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class FragOne extends Fragment {

    GridView gv_adult, gv_freemobilegames, gv_health, gv_home, gv_news, gv_reference, gv_shopping, gv_socialmedia, gv_sports, gv_technology, gv_videosharing;
    Button btn_adult, btn_mobilegames, btn_health, btn_home, btn_news, btn_reference, btn_shopping, btn_socialmedia, btn_sports, btn_technology, btn_videosharing;

    AdView mainbanner;

    String videosharing_textarray[] = {"Dailymotion", "Viemo", "Metacafe", "IMDB"};
    int videosharing_imgarray[] = {R.drawable.video_dailymotion, R.drawable.video_viemo, R.drawable.video_metacafe, R.drawable.video_imdb};

    String technology_textarray[] = {"Ted", "How Stuff Works", "AutoDesk", "Popular Mechanics", "Live Science", "PC World"};
    int technology_imgarray[] = {R.drawable.technology_ted, R.drawable.technology_howstuffworks, R.drawable.technology_autodesk, R.drawable.technology_popularmechanics, R.drawable.technology_livescience, R.drawable.technology_pcworld};

    String sports_textarray[] = {"BBC Sports", "ESPN", "Cricbuzz", "FIFA", "IPL", "Yahoo Sports"};
    int sports_imgarray[] = {R.drawable.sports_bbcsports, R.drawable.sports_espn, R.drawable.sports_crizbuzz, R.drawable.sports_fifa, R.drawable.sports_indian_premier_league, R.drawable.sports_yahoosports};

    String socialmedia_textarray[] = {"Facebook", "Instagram", "Twitter", "Linkedin", "Google+", "Qeep"};
    int socialmedia_imagearray[] = {R.drawable.social_facebook_logo, R.drawable.social_instagram, R.drawable.social_twitter, R.drawable.social_linkedin, R.drawable.social_google_, R.drawable.social_qeep};

    String shopping_textarray[] = {"Amazon", "Flipkart", "eBay", "Shopclues", "Homeshop18"};
    int shopping_imgarray[] = {R.drawable.shopping_amazon, R.drawable.shopping_flipkart, R.drawable.shoppingebay, R.drawable.shopping_shopclues, R.drawable.shopping_homeshop};

    String reference_textarray[] = {"Stack Overflow", "Stack Exchange", "Quora", "Google Maps", "Ask", "Yahoo Answers"};
    int reference_imgarray[] = {R.drawable.reference_stackoverflow, R.drawable.reference_stackexchange, R.drawable.reference_quora, R.drawable.reference_maps, R.drawable.reference_ask, R.drawable.reference_yahoo_answers};

    String news_textarray[] = {"BBC", "CNN", "India Today", "NDTV", "Google News", "Times Now"};
    int news_imgarray[] = {R.drawable.news_bbc, R.drawable.news_cnn, R.drawable.news_indiatoday, R.drawable.news_ndtv, R.drawable.news_googlenews, R.drawable.news_timesnow};

    String home_textarray[] = {"Bawarchi", "AllRecipes", "The Kitchen", "Indian Recipes", "Food"};
    int home_imgarray[] = {R.drawable.cooking_bawarchi, R.drawable.cooking_allrecipes, R.drawable.cooking_thekitchn, R.drawable.cooking_indianrecipes, R.drawable.cooking_food};

    String health_textarray[] = {"Everyday Health", "Health Grades", "NIH", "MayoClinic", "Yahoo Health", "Medicine.Net"};
    int health_imgarray[] = {R.drawable.health_everydayhealth, R.drawable.health_healthgrades, R.drawable.health_nih, R.drawable.health_mayoclinic, R.drawable.health_yahoohealth, R.drawable.health_medicinenet};

    String freemobilegames_textarray[] = {"Play Mob", "MoboGenie", "Nine Games", "ApkPure", "Apk for fun"};
    int freemobilegames_imgarray[] = {R.drawable.games_playmob, R.drawable.games_mobogenie, R.drawable.games_ninegames, R.drawable.games_apkpure, R.drawable.games_apkforfun};

    public FragOne() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_frag_one, container, false);


        gv_freemobilegames = (GridView) view.findViewById(R.id.gv_mobilegames_gridview);
        gv_health = (GridView) view.findViewById(R.id.gv_health_gridview);
        gv_home = (GridView) view.findViewById(R.id.gv_cooking_gridview);
        gv_news = (GridView) view.findViewById(R.id.gv_news_gridview);
        gv_reference = (GridView) view.findViewById(R.id.gv_reference_gridview);
        gv_shopping = (GridView) view.findViewById(R.id.gv_shopping_gridview);
        gv_socialmedia = (GridView) view.findViewById(R.id.gv_social_gridview);
        gv_sports = (GridView) view.findViewById(R.id.gv_sports_gridview);
        gv_technology = (GridView) view.findViewById(R.id.gv_technology_gridview);
        gv_videosharing = (GridView) view.findViewById(R.id.gv_video_gridview);


        btn_mobilegames = (Button) view.findViewById(R.id.btn_mobilegames);
        btn_health = (Button) view.findViewById(R.id.btn_health);
        btn_home = (Button) view.findViewById(R.id.btn_cooking);
        btn_news = (Button) view.findViewById(R.id.btn_news);
        btn_reference = (Button) view.findViewById(R.id.btn_reference);
        btn_shopping = (Button) view.findViewById(R.id.btn_shopping);
        btn_socialmedia = (Button) view.findViewById(R.id.btn_social_seemore);
        btn_sports = (Button) view.findViewById(R.id.btn_sports);
        btn_technology = (Button) view.findViewById(R.id.btn_technology);
        btn_videosharing = (Button) view.findViewById(R.id.btn_videosharing);



        btn_mobilegames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FreeMobileGames.class));
            }
        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Health.class));
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Home.class));
            }
        });

        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), News.class));
            }
        });

        btn_reference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Reference.class));
            }
        });

        btn_shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Shopping.class));
            }
        });

        btn_socialmedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SocialMedia.class));
            }
        });

        btn_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Sports.class));
            }
        });

        btn_technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Technology.class));
            }
        });

        btn_videosharing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VideoSharing.class));
            }
        });





        if (!isNetworkConnected()) {
            Toast.makeText(getActivity(), "No Internet available", Toast.LENGTH_LONG).show();
            getActivity().finish();
        }



        gv_freemobilegames.setAdapter(new freemobilegamesadap(getActivity(), 0));

        gv_freemobilegames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        Case("http://www.9game.com");
                        break;
                    }
                    case 3: {
                        Case("https://apkpure.com");
                        break;
                    }

                    case 4: {
                        Case("https://www.apk4fun.com");
                        break;
                    }
                    default: {

                    }
                }
            }
        });

        gv_health.setAdapter(new healthadap(getActivity(), 0));

        gv_health.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.everydayhealth.com/");
                        break;
                    }
                    case 1: {
                        Case("https://www.healthgrades.com");
                        break;
                    }
                    case 2: {
                        Case("https://www.nih.gov/");
                        break;
                    }
                    case 3: {
                        Case("http://www.mayoclinic.org/");
                        break;
                    }
                    case 4: {
                        Case("https://www.yahoo.com/news/tagged/health/");
                        break;
                    }
                    case 5: {
                        Case("http://www.medicinenet.com/");
                        break;
                    }
                    default: {

                    }
                }
            }
        });

        gv_home.setAdapter(new homeadap(getActivity(), 0));

        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.bawarchi.com/");
                        break;
                    }
                    case 1: {
                        Case("http://www.Allrecipes.com");
                        break;
                    }
                    case 2: {
                        Case("http://www.thekitchn.com/");
                        break;
                    }
                    case 3: {
                        Case("http://simpleindianrecipes.com/");
                        break;
                    }

                    case 4: {
                        Case("http://www.food.com/");
                        break;
                    }
                    default: {

                    }
                }

            }
        });

        gv_news.setAdapter(new newsadap(getActivity(), 0));

        gv_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        Case("http://indiatoday.intoday.in/");
                        break;
                    }

                    case 3: {
                        Case("http://www.ndtv.com/");
                        break;
                    }
                    case 4: {
                        Case("https://news.google.co.in/");
                        break;
                    }

                    case 5: {
                        Case("http://www.timesnow.tv/");
                        break;
                    }

                    default: {

                    }
                }
            }
        });

        gv_reference.setAdapter(new referenceadap(getActivity(), 0));

        gv_reference.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://stackoverflow.com/");
                        break;
                    }
                    case 1: {
                        Case("http://stackexchange.com/");
                        break;
                    }

                    case 2: {
                        Case("https://www.quora.com/");
                        break;
                    }
                    case 3: {
                        Case("https://www.google.co.in/maps/");
                        break;
                    }
                    case 4: {
                        Case("http://www.ask.com/");
                        break;
                    }
                    case 5: {
                        Case("https://in.answers.yahoo.com/");
                        break;
                    }
                    default: {

                    }
                }
            }
        });

        gv_shopping.setAdapter(new shoppingadap(getActivity(), 0));

        gv_shopping.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.amazon.in/");
                        break;
                    }
                    case 1: {
                        Case("https://www.flipkart.com/");
                        break;
                    }
                    case 2: {
                        Case("http://www.ebay.in/");
                        break;
                    }
                    case 3: {
                        Case("http://www.shopclues.com/");
                        break;
                    }
                    case 4: {
                        Case("http://www.homeshop18.com/");
                        break;
                    }

                    default: {

                    }
                }
            }
        });

        gv_socialmedia.setAdapter(new socialadap(getActivity(), 0));

        gv_socialmedia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.Facebook.com");
                        break;
                    }
                    case 1: {
                        Case("https://www.instagram.com/");
                        break;
                    }
                    case 2: {
                        Case("https://twitter.com/");
                        break;
                    }

                    case 3: {
                        Case("https://www.linkedin.com");
                        break;
                    }

                    case 4: {
                        Case("https://plus.google.com/");
                        break;
                    }
                    case 5: {
                        Case("http://qeep.mobi/xmps/homepage.do");
                        break;
                    }
                    default: {
                        break;
                    }

                }
            }

        });

        gv_sports.setAdapter(new sportsadap(getActivity(), 0));

        gv_sports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("http://www.bbc.co.uk/sport");
                        break;
                    }
                    case 1: {
                        Case("http://www.espn.in/");
                        break;
                    }
                    case 2: {
                        Case("http://www.cricbuzz.com/");
                        break;
                    }
                    case 3: {
                        Case("http://www.fifa.com/");
                        break;
                    }
                    case 4: {
                        Case("http://www.iplt20.com/");
                        break;
                    }
                    case 5: {
                        Case("https://in.news.yahoo.com/");
                        break;
                    }

                    default: {

                    }
                }
            }
        });

        gv_technology.setAdapter(new technologyadap(getActivity(), 0));

        gv_technology.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: {
                        Case("https://www.ted.com/");
                        break;
                    }
                    case 1: {
                        Case("http://www.Howstuffworks.com");
                        break;
                    }
                    case 2: {
                        Case("http://www.autodesk.com/");
                        break;
                    }
                    case 3: {
                        Case("http://www.Popularmechanics.com");
                        break;
                    }
                    case 4: {
                        Case("http://www.livescience.com/");
                        break;
                    }
                    case 5: {
                        Case("http://www.pcworld.com/");
                    }
                    default: {

                    }
                }
            }
        });

        gv_videosharing.setAdapter(new videoadap(getActivity(), 0));

        gv_videosharing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0: {
                        Case("http://www.youtube.com");
                        break;
                    }
                    case 1: {
                        Case("http://www.dailymotion.com/in");
                        break;
                    }
                    case 2: {
                        Case("https://vimeo.com/");
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
        });


        return view;

    }

    private String Case(String reg) {
        Intent intent = new Intent(getActivity(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }



    public class freemobilegamesadap extends ArrayAdapter {

        public freemobilegamesadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return freemobilegames_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(freemobilegames_imgarray[position]);
            rowtext.setText(freemobilegames_textarray[position]);
            return row;
        }
    }


    public class healthadap extends ArrayAdapter {

        public healthadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return health_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(health_imgarray[position]);
            rowtext.setText(health_textarray[position]);
            return row;
        }
    }


    public class homeadap extends ArrayAdapter {

        public homeadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return home_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(home_imgarray[position]);
            rowtext.setText(home_textarray[position]);
            return row;
        }
    }


    public class newsadap extends ArrayAdapter {

        public newsadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return news_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(news_imgarray[position]);
            rowtext.setText(news_textarray[position]);
            return row;
        }
    }


    public class referenceadap extends ArrayAdapter {

        public referenceadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return reference_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(reference_imgarray[position]);
            rowtext.setText(reference_textarray[position]);
            return row;
        }
    }


    public class shoppingadap extends ArrayAdapter {

        public shoppingadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return shopping_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(shopping_imgarray[position]);
            rowtext.setText(shopping_textarray[position]);
            return row;
        }
    }


    public class sportsadap extends ArrayAdapter {

        public sportsadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return sports_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(sports_imgarray[position]);
            rowtext.setText(sports_textarray[position]);
            return row;
        }
    }


    public class technologyadap extends ArrayAdapter {

        public technologyadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return technology_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(technology_imgarray[position]);
            rowtext.setText(technology_textarray[position]);
            return row;
        }
    }


    public class videoadap extends ArrayAdapter {

        public videoadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return videosharing_imgarray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(videosharing_imgarray[position]);
            rowtext.setText(videosharing_textarray[position]);
            return row;
        }
    }


    private class socialadap extends ArrayAdapter {

        public socialadap(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return socialmedia_imagearray.length;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.grid_row, parent, false);
            ImageView rowimage = (ImageView) row.findViewById(R.id.row_image);
            TextView rowtext = (TextView) row.findViewById(R.id.row_textview);
            rowimage.setImageResource(socialmedia_imagearray[position]);
            rowtext.setText(socialmedia_textarray[position]);
            return row;
        }
    }

    public boolean isNetworkConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

    }


}

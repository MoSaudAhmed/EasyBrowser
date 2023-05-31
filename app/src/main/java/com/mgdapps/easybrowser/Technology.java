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

public class Technology extends AppCompatActivity {

    ListView lv_technology_list;


    String titlearray[] = {"NCBI", "TED", "AUTODESK", "PC World", "howstuffworks", "Popular Mechanics", "IEEE", "NASA, Space Exploration and Astronomy News","Live Science"};
        String infoarray[] = {"National Center for Biotechnology Information. Search database ... GEO Profiles, GSS, GTR, HomoloGene, MedGen, MeSH, NCBI Web Site, NLM Catalog, Nucleotide", "TED Talks are influential videos from expert speakers on education, business, science, tech and creativity, with subtitles in 100+ languages. Ideas free to stream", "Autodesk builds software that helps people imagine, design, and create a better world.", "PCWorld.in is your trusted source for the latest Technology News, Product Reviews, Free PC Software Downloads, Videos, Opinions, How To and Features", "HowStuffWorks explains thousands of topics, from engines to lock-picking to ESP, with video and illustrations so you can learn how everything works.", "Popular Mechanics inspires, instructs and influences readers to help them master the modern world. Whether it's practical DIY home-improvement tips, gadgets ...", "IEEE.org serves technical professionals and students who are looking to both foster working relationships and gain access to the latest technical research and", "Get the latest space exploration, innovation and astronomy news. Space.com celebrates humanity's ongoing expansion across the final frontier.", "Live Science makes every day a little more interesting by illuminating the amazing world around us."};
    int imagearray[] = {R.drawable.technology_ncbi,R.drawable.technology_ted,R.drawable.technology_autodesk,R.drawable.technology_pcworld,R.drawable.technology_howstuffworks,R.drawable.technology_popularmechanics,R.drawable.technology_ieee,R.drawable.technology_space,R.drawable.technology_livescience};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);

        lv_technology_list = (ListView) findViewById(R.id.lv_technology_list);

        lv_technology_list.setAdapter(new technologyadapter(getApplicationContext(), 0));

        lv_technology_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0: {
                        Case("https://www.ncbi.nlm.nih.gov/");
                        break;
                    }
                    case 1: {
                        Case("https://www.ted.com/");
                        break;
                    }
                    case 2: {
                        Case("http://www.autodesk.com/");
                        break;
                    }
                    case 3: {
                        Case("http://www.pcworld.com/");
                        break;
                    }
                    case 4: {
                        Case("http://www.Howstuffworks.com");
                        break;
                    }
                    case 5: {
                        Case("http://www.Popularmechanics.com");
                        break;
                    }
                    case 6: {
                        Case("http://www.ieee.org/index.html");
                        break;
                    }

                    case 7: {
                        Case("http://www.space.com/");
                        break;
                    }
                    case 8: {
                        Case("http://www.livescience.com/");
                        break;
                    }
                    default: {

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

    private class technologyadapter extends ArrayAdapter {

        public technologyadapter(Context context, int resource) {
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
            list_row_info.setText(infoarray[position]);
            list_row_title.setText(titlearray[position]);

            return row;
        }
    }
}

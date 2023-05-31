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

public class Reference extends AppCompatActivity {

    ListView lv_reference_list;

    String titlearray[]={"Google Maps","Quora","Stack Exchange","Yahoo Answers","Stack Overflow","Ask Ubuntu","Answerbag","Answers","Ask"};
    String infoarray[]={"Find local businesses, view maps and get driving directions in Google Maps","Quora is a question-and-answer site where questions are asked, answered, edited and organized by its community of users.","Relating to all categories from tech , health , user experience etc.","One of the best and most widely used Q&A site.","For all coders who want to share their code and find help in coding.","Again for tech related queries.","Ask Questions, Get Answers, Find Information - Just like yahoo answers you can fire and find answers all type of questions.","The Most Trusted Place for Answering Life's Questions - Similar to yahoo answers but the GUI is better","It is the #1 question answering service that delivers the best answers from the web and real people - all in one place."};
    int imagearray[]={R.drawable.reference_maps,R.drawable.reference_quora,R.drawable.reference_stackexchange,R.drawable.reference_yahoo_answers,R.drawable.reference_stackoverflow,R.drawable.reference_ask_ubuntu,R.drawable.reference_answers,R.drawable.reference_ask};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);

        lv_reference_list=(ListView)findViewById(R.id.lv_reference_list);

        lv_reference_list.setAdapter(new referenceadapter(getApplicationContext(),0));

        lv_reference_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    {
                        Case("https://www.google.co.in/maps/");
                        break;
                    }
                    case 1:
                    {
                        Case("https://www.quora.com/");
                        break;
                    }

                    case 2:
                    {
                        Case("http://stackexchange.com/");
                        break;
                    }
                    case 3:
                    {
                        Case("https://in.answers.yahoo.com/");
                        break;
                    }
                    case 4:
                    {
                        Case("http://stackoverflow.com/");
                        break;
                    }
                    case 5:
                    {
                        Case("http://askubuntu.com/");
                        break;
                    }
                    case 6:
                    {
                        Case("http://www.answerbag.com/");
                        break;
                    }
                    case 7:
                    {
                        Case("http://www.answers.com/");
                        break;
                    }
                    case 8:
                    {
                        Case("https://www.question.com/");
                        break;
                    }

                    case 9:
                    {
                        Case("http://www.ask.com/");
                        break;
                    }
                    default:
                    {

                    }
                }
            }
        });
    }

    private String Case(String reg)
    {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }


    private class referenceadapter extends ArrayAdapter
    {

        public referenceadapter(Context context, int resource) {
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

           View row= layoutInflater.inflate(R.layout.list_row,parent,false);

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

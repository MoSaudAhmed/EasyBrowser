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

public class Health extends AppCompatActivity {

    ListView lv_health_list;

    String titlearray[]={"WebMD","NIH","Yahoo Health","Mayo Clinic","MedicineNet","Drugs","Everyday Health","Healthgrades"};
    String inforarray[]={"WebMD is an American corporation known primarily as an online publisher of news and information pertaining to human health and well-being","NIH is one of the world's foremost medical research centers.","The latest health news, workouts, recipes, and inspiration for healthy living.","At Mayo Clinic, over 3300 physicians, scientists and researchers share their expertise to empower you. Learn why it's the right place for your health care.","Read doctor-produced health and medical information written for you to make informed decisions about your health concerns.","Online drug information in an A to Z format. Includes information about clinical trials, latest news, drug interactions, and a pill identifier.","Health resources and personalized health tools. Information and news on depression, digestive health, diabetes, breast cancer, cardiovascular health","Healthgrades is the leading online resource for comprehensive information about physicians and hospitals."};
    int imagearray[]={R.drawable.health_webmd,R.drawable.health_nih,R.drawable.health_yahoohealth,R.drawable.health_mayoclinic,R.drawable.health_medicinenet,R.drawable.health_drugs,R.drawable.health_everydayhealth,R.drawable.health_healthgrades};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        lv_health_list=(ListView)findViewById(R.id.lv_health_list);

        listadapter listadapter=new listadapter(getApplicationContext(),1);

        lv_health_list.setAdapter(listadapter);

        lv_health_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                    {
                        Case("http://www.webmd.com/");
                        break;
                    }
                    case 1:
                    {
                        Case("https://www.nih.gov/");
                        break;
                    }
                    case 2:
                    {
                        Case(" https://www.yahoo.com/news/tagged/health/");
                        break;
                    }
                    case 3:
                    {
                        Case("http://www.mayoclinic.org/");
                        break;
                    }
                    case 4:
                    {
                        Case("http://www.medicinenet.com/");
                        break;
                    }
                    case 5:
                    {
                        Case("https://www.drugs.com/");
                        break;
                    }

                    case 6:
                    {
                        Case("http://www.everydayhealth.com/");
                        break;
                    }
                    case 7:
                    {
                        Case("https://www.healthgrades.com");
                        break;
                    }
                    default:
                    {

                    }
                }
            }
        });

        //http://www.webmd.com/,https://www.nih.gov/, https://www.yahoo.com/news/tagged/health/,http://www.mayoclinic.org/,http://www.medicinenet.com/, https://www.drugs.com/,http://www.everydayhealth.com/, https://www.healthgrades.com/

    }

    private String Case(String reg)
    {
        Intent intent = new Intent(getApplicationContext(), Facebook.class);
        intent.putExtra("result", reg);
        startActivity(intent);
        return null;
    }

    private class listadapter extends ArrayAdapter
    {

        public listadapter(Context context, int resource) {
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
            list_row_title.setText(titlearray[position]);
            list_row_info.setText(inforarray[position]);

            return row;
        }
    }
}

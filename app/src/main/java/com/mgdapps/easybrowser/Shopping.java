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

public class Shopping extends AppCompatActivity {

    ListView lv_shopping_list;

    String titlearray[] = {"Amazon","Flipkart","eBay","Shopclues","Myntra","Homeshop18","Shoppers Stop","Jabong","Limeroad"};
    String infoarray[] = {" Online Shopping India - Buy mobiles, laptops, cameras, books, watches, apparel, shoes and e-Gift Cards. Free Shipping & Cash on Delivery ","Shop Online for mobiles, electronics, appliances, lifestyle and wide range of original products with cash on delivery and free shipping options only at India's Best","Buy and sell electronics, cars, fashion apparel, collectibles, sporting goods, digital cameras, baby items, coupons, and everything else on eBay","Shop Online for the biggest range of Mobile Phones, Laptops, Home Appliances, Electronics, Fashion, Shoes and Home & Kitchen products at the lowest Prices.","Online Shopping site in India for Branded Shoes, Clothing; Accessories for Men and Women. Shop online & avail ✯ Free Shipping ✯ Cash on Delivery ✯ 30 Day","Online Shopping in India for Men, Women and Kids. Buy Latest Mobiles, Home & Kitchen Accessories, Jewellery, Clothing and more at Homeshop18.","Save big! Upto 50% off on clothing, accessories and more for Men, Women and kids","Online shopping in India for men, women & kids for shoes, clothing, watches, sunglasses at Jabong.com. ✓ free shipping* ✓ Cash on Delivery ✓ 15 days Return.","Online Shopping of Clothing, Shoes, Bags, Accessories at Limeroad.com. Create Scrapbooks, Stories with one of the best Online Shopping Sites in India"};
    int imagearray[] = {R.drawable.shopping_amazon,R.drawable.shopping_flipkart,R.drawable.shoppingebay,R.drawable.shopping_shopclues,R.drawable.shopping_myntra,R.drawable.shopping_homeshop,R.drawable.shopping_shoppersstop,R.drawable.shopping_jabong,R.drawable.shopping_limeroad};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        lv_shopping_list = (ListView) findViewById(R.id.lv_shopping_list);

        shoppingadapter shoppingadapter = new shoppingadapter(getApplicationContext(), 0);

        lv_shopping_list.setAdapter(shoppingadapter);
        lv_shopping_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
                        Case("http://www.myntra.com/");
                        break;
                    }
                    case 5: {
                        Case("http://www.homeshop18.com/");
                        break;
                    }
                    case 6: {
                        Case("https://www.shoppersstop.com/");
                        break;
                    }
                    case 7: {
                        Case("http://www.jabong.com/");
                        break;
                    }
                    case 8: {
                        Case("http://www.limeroad.com/");
                        break;
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


    private class shoppingadapter extends ArrayAdapter {

        public shoppingadapter(Context context, int resource) {
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

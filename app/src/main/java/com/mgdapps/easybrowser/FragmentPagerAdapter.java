package com.mgdapps.easybrowser;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 11/9/2016.
 */

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> tabsarray = new ArrayList<>();

    public void addfragment(Fragment fragment, String tabsarray) {
        this.fragmentList.add(fragment);
        this.tabsarray.add(tabsarray);

    }

    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsarray.get(position);
    }
}

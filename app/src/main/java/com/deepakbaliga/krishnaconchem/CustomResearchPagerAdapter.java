package com.deepakbaliga.krishnaconchem;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by baliga on 29/04/16.
 */
public class CustomResearchPagerAdapter extends PagerAdapter {

    private Context mContext;

    public CustomResearchPagerAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        CustomResearchPagerEnum customPagerEnum = CustomResearchPagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return CustomResearchPagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
        return "";
    }
}

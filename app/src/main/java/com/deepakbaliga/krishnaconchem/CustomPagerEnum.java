package com.deepakbaliga.krishnaconchem;

/**
 * Created by baliga on 29/04/16.
 */
public enum  CustomPagerEnum {

    PAGE_ONE(R.layout.pager_one),
    PAGE_TWO(R.layout.pager_two);


    private int mLayoutResId;

    CustomPagerEnum(int layoutResId) {

        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }


}

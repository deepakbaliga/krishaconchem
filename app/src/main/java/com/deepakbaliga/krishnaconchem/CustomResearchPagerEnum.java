package com.deepakbaliga.krishnaconchem;

/**
 * Created by baliga on 29/04/16.
 */
public enum CustomResearchPagerEnum {

    PAGE_ONE(R.layout.research_pager_one),
    PAGE_TWO(R.layout.research_pager_two),
    PAGE_THREE(R.layout.research_pager_three);


    private int mLayoutResId;

    CustomResearchPagerEnum(int layoutResId) {

        mLayoutResId = layoutResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }



}

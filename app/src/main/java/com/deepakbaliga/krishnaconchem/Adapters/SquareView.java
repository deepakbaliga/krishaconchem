package com.deepakbaliga.krishnaconchem.Adapters;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by baliga on 04/05/16.
 */
public class SquareView extends ImageView {

    public SquareView(Context context) {
        super(context);
    }

    public SquareView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}

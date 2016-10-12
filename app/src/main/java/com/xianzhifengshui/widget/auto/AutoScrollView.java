package com.xianzhifengshui.widget.auto;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.zhy.autolayout.utils.AutoLayoutHelper;


public class AutoScrollView extends ScrollView {
    private final AutoLayoutHelper helper = new AutoLayoutHelper(this);

    public AutoScrollView(Context context) {
        super(context);
    }

    public AutoScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (isInEditMode()){
            helper.adjustChildren();
        }
    }
    @Override
    public AutoScrollView.LayoutParams generateLayoutParams(AttributeSet attrs)
    {
        return new AutoScrollView.LayoutParams(getContext(), attrs);
    }

}

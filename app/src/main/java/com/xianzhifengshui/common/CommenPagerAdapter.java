package com.xianzhifengshui.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xianzhifengshui.base.BaseFragment;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/10.
 * 描述: ViewPagerAdapter
 */
public class CommenPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;

    public CommenPagerAdapter(FragmentManager fm,List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

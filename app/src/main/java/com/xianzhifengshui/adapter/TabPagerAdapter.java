package com.xianzhifengshui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xianzhifengshui.base.BaseFragment;
import com.xianzhifengshui.common.CommenPagerAdapter;

import java.util.List;

/**
 * 作者: 陈冠希
 * 日期: 2016/10/10.
 * 描述: TabViewPagerAdapter
 */
public class TabPagerAdapter extends CommenPagerAdapter{
    private String[] titles;

    public TabPagerAdapter(FragmentManager fm, String[] titles, List<BaseFragment> fragments) {
        super(fm,fragments);
        this.titles = titles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position % titles.length];
    }
}

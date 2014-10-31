package com.nonobank.ui.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.nonobank.ui.fragment.BaseFragment;

public class RepayViewPagerAdapter extends FragmentStatePagerAdapter  {
	List<BaseFragment> mFragments;
	private FragmentManager mFragmentManager;
	FragmentTransaction mCurTransaction;

	public RepayViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public RepayViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
		super(fm);
		mFragmentManager = fm;
		mFragments = fragments;
	}


	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

}

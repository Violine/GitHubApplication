package com.example.githubapplication.Adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.githubapplication.Fragments.MyInfoFragment;
import com.example.githubapplication.Fragments.RepositoriesFragments;
import com.example.githubapplication.Fragments.SettingsFragments;

public class GithubAppPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Мой профиль", "Мои Репо", "Настройки" };
    private Context context;

    public GithubAppPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new MyInfoFragment();
            case 1:
                return new RepositoriesFragments();
            case 2:
                return new SettingsFragments();
            default:
                return new MyInfoFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}

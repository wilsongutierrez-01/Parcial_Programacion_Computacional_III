package com.gutierrez.week3_tabs.Controls;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerController  extends FragmentPagerAdapter {
    //****controls tabs****
    int tabNum;

    //**** Create Constructor***********


    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.tabNum = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ///*** choose fragment to show********
        switch (position){
            case 0:
                return new Contacts();

            case 1:
                return new Email();

            case 2:
                return new Message();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        //****** returns number's tabs*****

        return tabNum;
    }
}

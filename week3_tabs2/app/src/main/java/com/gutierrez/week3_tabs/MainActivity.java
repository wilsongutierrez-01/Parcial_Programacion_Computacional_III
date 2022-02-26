package com.gutierrez.week3_tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.gutierrez.week3_tabs.Controls.PagerController;

public class MainActivity extends AppCompatActivity {
    TabLayout layout;
    ViewPager viewP;
    TabItem tabEmail, tabMessage, tabContacts;
    //**** PagerController*******
    PagerController pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkComps();

        ///************* Fragments controls**********************
        pagerAdapter = new PagerController(getSupportFragmentManager(),layout.getTabCount());

        //**************** Showing fragments********
        viewP.setAdapter(pagerAdapter);

        // ********************** Click event fot tabs ********************
        try {
            layout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    //**** Get tab position to show *******
                    viewP.setCurrentItem(tab.getPosition());
                    //******* choose fragment to show ********
                    if (tab.getPosition() == 0){
                        pagerAdapter.notifyDataSetChanged();
                    }
                    if (tab.getPosition() == 1){
                        pagerAdapter.notifyDataSetChanged();
                    }
                    if (tab.getPosition() == 2){
                        pagerAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

        }catch (Exception e){
            toastMsg(e.getMessage());
        }


        //**** Decide the fragment to show ******************
        viewP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));

    }

    ////******************Linking the components*****************************
    private void linkComps (){
        layout = findViewById(R.id.tabLayout);
        viewP = findViewById(R.id.view);
        tabContacts = findViewById(R.id.tbContacts);
        tabEmail = findViewById(R.id.tbEmail);
        tabMessage = findViewById(R.id.tbMessage);
    }


    private void toastMsg (String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
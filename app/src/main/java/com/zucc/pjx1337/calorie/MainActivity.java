package com.zucc.pjx1337.calorie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zucc.pjx1337.calorie.fragment.HomeFragment;
import com.zucc.pjx1337.calorie.fragment.SettingFragment;
import com.zucc.pjx1337.calorie.fragment.ShareFragment;
import com.zucc.pjx1337.calorie.fragment.SportsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    @BindView(R.id.main_layout)FrameLayout mainframeLayout;
    @BindView(R.id.navigation)BottomNavigationView navigation;
    private int lastFragmentNum;
    private HomeFragment homeFragment;
    private ShareFragment shareFragment;
    private SportsFragment sportsFragment;
    private SettingFragment settingFragment;
    private Fragment[] fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        initFragment();

    }


    //初始化fragment
    private void initFragment(){
        homeFragment = new HomeFragment();
        shareFragment = new ShareFragment();
        sportsFragment = new SportsFragment();
        settingFragment = new SettingFragment();
        fragments = new Fragment[]{homeFragment,shareFragment,sportsFragment,settingFragment};
        lastFragmentNum=0;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_layout,homeFragment).show(homeFragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                {
                    if(lastFragmentNum!=0)
                    {
                        switchFragment(lastFragmentNum,0);
                        lastFragmentNum=0;

                    }

                    return true;
                }
                case R.id.navigation_share:
                {
                    if(lastFragmentNum!=1)
                    {
                        switchFragment(lastFragmentNum,1);
                        lastFragmentNum=1;

                    }

                    return true;
                }

                case R.id.navigation_sports:
                {
                    if(lastFragmentNum!=2)
                    {
                        switchFragment(lastFragmentNum,2);
                        lastFragmentNum=2;

                    }

                    return true;
                }
                case R.id.navigation_setting:
                {
                    if(lastFragmentNum!=3)
                    {
                        switchFragment(lastFragmentNum,3);
                        lastFragmentNum=3;

                    }

                    return true;
                }
            }
            return false;
        }
    };

    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.main_layout,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }

}

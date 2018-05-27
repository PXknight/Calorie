package com.zucc.pjx1337.calorie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.zucc.pjx1337.calorie.Adapter.ViewPagerAdapter;
import com.zucc.pjx1337.calorie.Home.HomeFragment;
import com.zucc.pjx1337.calorie.Setting.SettingFragment;
import com.zucc.pjx1337.calorie.Share.ShareFragment;
import com.zucc.pjx1337.calorie.Sports.SportsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)BottomNavigationView bottomNavigationView;
    @BindView(R.id.viewpager)ViewPager viewPager;
    private HomeFragment homeFragment;
    private ShareFragment shareFragment;
    private SportsFragment sportsFragment;
    private SettingFragment settingFragment;
    MenuItem prevMenuItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        viewPager.addOnPageChangeListener(mOnOnPageChangeListener);

         //取消ViewPager滑动
       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });



        setupViewPager(viewPager);


    }

    //底部导航栏监听
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_share:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_sports:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_setting:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    //Pager改变监听
    private ViewPager.OnPageChangeListener mOnOnPageChangeListener
            = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (prevMenuItem != null) {
                prevMenuItem.setChecked(false);
            }
            else
            {
                bottomNavigationView.getMenu().getItem(0).setChecked(false);
            }
            Log.d("page", "onPageSelected: "+position);
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
            prevMenuItem = bottomNavigationView.getMenu().getItem(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    //加载ViewPager
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFragment=new HomeFragment();
        shareFragment=new ShareFragment();
        sportsFragment=new SportsFragment();
        settingFragment = new SettingFragment();
        adapter.addFragment(homeFragment);
        adapter.addFragment(shareFragment);
        adapter.addFragment(sportsFragment);
        adapter.addFragment(settingFragment);
        viewPager.setAdapter(adapter);
    }

}


package com.muzima.view.forms;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.muzima.R;
import com.muzima.adapters.MuzimaPagerAdapter;
import com.muzima.utils.Fonts;
import com.muzima.view.customViews.PagerSlidingTabStrip;
import com.muzima.view.preferences.SettingsActivity;


public abstract class FormsActivityBase extends SherlockFragmentActivity {
    private static final String TAG = "FormsActivityBase";
    protected ViewPager formsPager;
    protected PagerSlidingTabStrip pagerTabsLayout;
    protected MuzimaPagerAdapter formsPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPager();
        initPagerIndicator();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_in_from_left, R.anim.push_out_to_right);
    }

    private void initPager() {
        formsPager = (ViewPager) findViewById(R.id.pager);
        formsPagerAdapter = createFormsPagerAdapter();
        formsPagerAdapter.initPagerViews();
        formsPager.setAdapter(formsPagerAdapter);
    }

    protected abstract MuzimaPagerAdapter createFormsPagerAdapter();


    private void initPagerIndicator() {
        pagerTabsLayout = (PagerSlidingTabStrip) findViewById(R.id.pager_indicator);
        pagerTabsLayout.setTextColor(Color.WHITE);
        pagerTabsLayout.setTextSize((int) getResources().getDimension(R.dimen.pager_indicator_text_size));
        pagerTabsLayout.setSelectedTextColor(getResources().getColor(R.color.tab_indicator));
        pagerTabsLayout.setTypeface(Fonts.roboto_medium(this), -1);
        pagerTabsLayout.setViewPager(formsPager);
        formsPager.setCurrentItem(0);
        pagerTabsLayout.markCurrentSelected(0);
        pagerTabsLayout.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                onPageChange(position);
            }
        });
    }

    protected void onPageChange(int position){
    }
}

package com.designtest.app;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity{
    private static final int MENU_GROUP = 0;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        setupToolbar();
        setupNavigationView();
        setupDataFragment();
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void setupDataFragment() {
      /*  DataFragment dataFragment = (DataFragment) getSupportFragmentManager().findFragmentByTag(DATA_FRAGMENT_TAG);
        if (dataFragment == null) {
            dataFragment = (DataFragment) Fragment.instantiate(this, DataFragment.class.getName());
            dataFragment.setRetainInstance(true);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(dataFragment, DATA_FRAGMENT_TAG);
            transaction.commit();
        }*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                //NO-OP
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void selectArticle(CharSequence title) {
        Article article = articles.getArticle(title.toString());
    }

    private void setCurrentArticle(Article article) {
        setTitle(article.getTitle());
        ArticleViewPagerAdapter adapter = ArticleViewPagerAdapter.newInstance(getSupportFragmentManager(), this, article);
        viewPager.setAdapter(adapter);
        if (article.getPartsCount() <= 1) {
            tabLayout.setVisibility(View.GONE);
        } else {
            tabLayout.setVisibility(View.VISIBLE);
        }
        tabLayout.setupWithViewPager(viewPager);
    }*/
}

package com.chiragsavsani.customviews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.chiragsavsani.customviews.fragments.FragmentButton;
import com.chiragsavsani.customviews.fragments.FragmentEdittext;
import com.chiragsavsani.customviews.fragments.FragmentImage;
import com.chiragsavsani.customviews.fragments.FragmentTextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    NavigationView nvDrawer;

    int[] images = {R.drawable.background_image1, R.drawable.background_image2, R.drawable.background_image3, R.drawable.background_image4, R.drawable.background_image5,
            R.drawable.background_image6, R.drawable.background_image7, R.drawable.background_image8, R.drawable.background_image9, R.drawable.background_image10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nav_view);

        setupDrawerContent(nvDrawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

       /* NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        LinearLayout nav_header_back = (LinearLayout) findViewById(R.id.nav_header_back);
        nav_header_back.setBackgroundResource(getRandom());


        Fragment homeFragment = new FragmentTextView();
        if (homeFragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, homeFragment);
            fragmentTransaction.commit();
            setTitle("TextView");
        }
    }

    public int getRandom() {
        int rand = new Random().nextInt(images.length);
        return images[rand];

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the planet to show based on
        // position
        Fragment fragment = null;
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_textview:
                fragment = new FragmentTextView();
                break;
            case R.id.nav_edittext:
                fragment = new FragmentEdittext();
                break;
            case R.id.nav_button:
                fragment = new FragmentButton();
                break;
            case R.id.nav_imageview:
                fragment = new FragmentImage();
                break;
            default:
                fragment = new FragmentTextView();
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            fragmentTransaction.commit();
            menuItem.setChecked(true);
            setTitle(menuItem.getTitle());
            drawer.closeDrawers();
            // set the toolbar title
            //getSupportActionBar().setTitle(menuItem.getTitle());
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        switch (id) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
            case R.id.action_github:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ChiragSavsani/CustomViews"));
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

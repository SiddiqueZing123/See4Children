package com.zingbytes.see4children.activity.activity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.zingbytes.see4children.R;
import com.zingbytes.see4children.activity.fragment.HomeFragment;

import de.hdodenhof.circleimageview.CircleImageView;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    String mytitle="";
    boolean doubleBackToExitPressedOnce = false;
    private CircleImageView circleImageView;
    String HTTP_JSON_URL = "https://api.myjson.com/bins/1cb183";
    String Image_Name_JSON = "image_title";
    JsonArrayRequest AllfoodItemJSonArray;
    RequestQueue requestQueueAllfoodItem;
    public AutoCompleteTextView mAutoCompleteTextView;
    Toolbar toolbar;
    int mItemCount = 0;
    Context  context = this;
    private String fullname,user_id;
    TextView tvProfileName;
    TextView textCartItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("See4Children");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        circleImageView = (CircleImageView)navigationView.getHeaderView(0).findViewById(R.id.profileimage);
        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autocompletetextview);

        displaySelectedScreen(R.id.nav_menu1);


        /*fullname = SharedPreferencesUtil.getInstance(Home.this).getData(UtilsConstants.FULLNAME);
        user_id = SharedPreferencesUtil.getInstance(Home.this).getData(UtilsConstants.USER_ID);
        tvProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvProfilenameShow);
        tvProfileName.setText(fullname);
        Picasso.with(Home.this).load(BASE_PROFILE_URL+user_id+".jpg").placeholder(R.drawable.default_avatar).into(circleImageView);
*/
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (isTaskRoot()) {

            if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            {
                boolean done = getSupportFragmentManager().popBackStackImmediate();
            }
            else
            {
                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_dialog_alert)
                        .setTitle("Close")
                        .setMessage("Do you want to close See4Child app ? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //  mediaPlayer.stop();
                                //  status=false;
                                finish();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();

            }
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  menu.clear();
        getMenuInflater().inflate(R.menu.main, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_settings);

        /*View actionView = MenuItemCompat.getActionView(menuItem);
      //  textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_home:
                //add the function to perform here
                mAutoCompleteTextView.setVisibility(View.VISIBLE);
                Fragment fragment = new HomeFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                toolbar.setTitle("Home Page");
                toolbar.setTitleTextColor(Color.parseColor("#000"));
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();
                return(true);

        }
        return(super.onOptionsItemSelected(item));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
           // Toast.makeText(getApplicationContext(),"hii",Toast.LENGTH_LONG).show();
           // mAutoCompleteTextView.setVisibility(View.VISIBLE);
            Fragment fragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
         //   toolbar.setTitle("Home Page");
          //  toolbar.setTitleTextColor(Color.parseColor("#000"));
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();

           /* mAutoCompleteTextView.setVisibility(View.VISIBLE);
            displaySelectedScreen(R.id.nav_menu1);
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            toolbar.setTitle("See4Children");
            toolbar.setTitleTextColor(Color.parseColor("#73ad01"));
            startActivity(intent);*/

        }
        else if (id == R.id.nav_profile)
        {

         /*   mAutoCompleteTextView.setVisibility(View.GONE);
            Fragment fragment = new MaxziCoin();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            toolbar.setTitle("MAXZI COINS");
            toolbar.setTitleTextColor(Color.parseColor("#73ad01"));
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();*/

        }
        else if (id == R.id.nav_transhistory)
        {



        }
        else if (id == R.id.nav_certificates)
        {



        }
        else if (id == R.id.nav_chat)
        {



        }
        else if (id == R.id.nav_setting)
        {



        }
        else if (id == R.id.nav_logout) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){

          //  Picasso.with(Home.this).load(BASE_PROFILE_URL+user_id+".jpg").placeholder(R.drawable.default_avatar).into(circleImageView);

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    private void displaySelectedScreen(int itemId) {
        //creating fragment object
        Fragment fragment = null;
        //initializing the fragment object which is selected
        switch (itemId) {
           // case R.id.nav_share:
                //Toast.makeText(getApplicationContext(),"hii",Toast.LENGTH_LONG).show();
              /*  mAutoCompleteTextView.setVisibility(View.VISIBLE);
                 fragment = new HomeFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
              //  toolbar.setTitle("Home Page");
              //  toolbar.setTitleTextColor(Color.parseColor("#000"));
                ft.replace(R.id.content_frame, fragment);
                ft.addToBackStack(null);
                ft.commit();*/
         //   break;
          //  case R.id.nav_send:
               // fragment = new Market();
              //  break;
           /* case R.id.nav_menu3:
                fragment = new Eats();
                break;*/
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}


package com.intranet.app.ui.Activity.NavTest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.Login.LoginActivity;
import com.intranet.app.ui.Activity.Nota.NotaFragment;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.utils.SharedPrefManager;

import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Main3Activity extends MainFragmentActivity implements NavigationView.OnNavigationItemSelectedListener {


    ImageView imge;

    TextView txtusername;
    TextView txtemail;

    ImageView img1;

    private SharedPrefManager pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("MyAras");

        HomePageFragment fragment = new HomePageFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle args = new Bundle();

        final View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        imge = (ImageView)headerLayout.findViewById(R.id.imageViewNavdrawer);

        txtusername = (TextView) headerLayout.findViewById(R.id.txtusername);
        txtemail = (TextView) headerLayout.findViewById(R.id.txtemail);

        pref = new SharedPrefManager(Main3Activity.this);

        HashMap<String, String> stringObject = pref.getUsername();
        final String sobject = stringObject.get(SharedPrefManager.USERNAME);

        Gson gson = new Gson();
        LoginReceive obj = gson.fromJson(sobject , LoginReceive.class);
        Log.e("test" , obj.getUsername());

        txtemail.setText(obj.getEmail());
        txtusername.setText(obj.getUsername());

        pref = new SharedPrefManager(Main3Activity.this);
        img1 = (ImageView) findViewById(R.id.imageViewNavdrawer) ;

    }

    public void setlogout(final Activity act) {

        if (act != null) {
            if (!act.isFinishing()) {

                new SweetAlertDialog(act, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure you want to Logout?")
                        //.setContentText("Won't be able to recover this file!")
                        .setConfirmText("Log out")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                Intent in = new Intent(Main3Activity.this , LoginActivity.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                finish();
                                startActivity(in);



                            }
                        })
                        .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
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
        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_logout) {
//            finish();
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


//    private void deleteAppData() {
//        try {
//            // clearing app data
//            String packageName = getApplicationContext().getPackageName();
//            Runtime runtime = Runtime.getRuntime();
//            runtime.exec("pm clear "+packageName);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            HomePageFragment fragment = new HomePageFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();

        }

        else if (id == R.id.nav_bacanota) {
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar100);
//            toolbar.setVisibility(View.GONE);
//            MakmalFragment fragment = new MakmalFragment();
//            android.support.v4.app.FragmentTransaction fragmentTransaction =
//                    getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.frame, fragment);
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_sertaimakmal) {



        } else if (id == R.id.nav_kuiz) {



        } else if (id == R.id.nav_tetapan) {


        } else if (id == R.id.action_logout) {

            setlogout(Main3Activity.this);
            pref.setLoginStatus("false");



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

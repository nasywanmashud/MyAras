package com.intranet.app.ui.Activity.Daftar;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.Login.LoginFragment;

import butterknife.ButterKnife;

/**
 * This is activity class for LoginFragment
 */
public class DaftarActivity extends MainFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
////        setSupportActionBar(toolbar);
//        toolbar.setTitle("Login");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, DaftarFragment.newInstance()).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    //@Override
    //public int getFragmentContainerId() {
       //return R.id.main_activity_fragment_container;
    //}
}

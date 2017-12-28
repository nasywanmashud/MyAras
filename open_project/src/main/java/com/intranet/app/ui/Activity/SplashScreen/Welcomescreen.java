package com.intranet.app.ui.Activity.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.intranet.app.R;
import com.intranet.app.ui.Activity.HomePage.HomePageActivity;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.Login.LoginActivity;
import com.intranet.app.ui.Activity.NavTest.Main3Activity;
import com.intranet.app.utils.SharedPrefManager;

import java.util.HashMap;

public class Welcomescreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000;
    private SharedPrefManager pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {

//               Intent next = new Intent(Welcomescreen.this, LoginActivity.class);
//               startActivity(next);
//               finish();
               pref = new SharedPrefManager(Welcomescreen.this);

               HashMap<String, String> loginstatus = pref.getLoginStatus();
               final String lstatus = loginstatus.get(SharedPrefManager.LOGINSTATUS);

               if(lstatus != null){

                   if (lstatus.equals("true")) {
                       Intent next = new Intent(Welcomescreen.this, Main3Activity.class);
//                       Intent next = new Intent(Welcomescreen.this, HomePageActivity.class);
                       finish();
                       startActivity(next);
                   }
                   else {
                       Intent next = new Intent(Welcomescreen.this, LoginActivity.class);
                       finish();
                       startActivity(next);
                   }

               }else {

                   Intent next = new Intent(Welcomescreen.this, LoginActivity.class);
                   finish();
                   startActivity(next);

               }


           }
       },SPLASH_TIME_OUT);


}


}

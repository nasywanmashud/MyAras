package com.intranet.app.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Button;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.intranet.app.MainController;
import com.intranet.app.R;
import com.intranet.app.utils.SharedPrefManager;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BaseFragment extends Fragment {

    public com.intranet.app.base.AQuery aq;
    static MediaPlayer backgroundMP;
    static int currentLength = 0;
    private static ProgressDialog progressDialog;
    private SharedPrefManager pref;
//    public static SweetAlertDialog pDialog ;

    public static void comic_backgroundMusic(Activity act) {
        if (backgroundMP != null) {
            backgroundMP.stop();
        }
        backgroundMP = MediaPlayer.create(act, R.raw.payon);
        backgroundMP.setLooping(true);
        backgroundMP.setVolume(80, 80);
        backgroundMP.start();
    }

    public static void comic_pauseBackgroundMusic() {
        if (backgroundMP != null) {
            backgroundMP.pause();
            currentLength = backgroundMP.getCurrentPosition();
        }
    }

    public static void comic_playBackgroundMusic(Activity act) {
        if (backgroundMP != null) {
            backgroundMP.stop();
            if (currentLength != 0) {
                backgroundMP = MediaPlayer.create(act, R.raw.payon);
                backgroundMP.setLooping(true);
                backgroundMP.setVolume(80, 80);
                backgroundMP.seekTo(currentLength);
                backgroundMP.start();
            } else {
                backgroundMP = MediaPlayer.create(act, R.raw.payon);
                backgroundMP.setLooping(true);
                backgroundMP.setVolume(80, 80);
                backgroundMP.start();
            }
        } else {
            backgroundMP = MediaPlayer.create(act, R.raw.payon);
            backgroundMP.setLooping(true);
            backgroundMP.setVolume(80, 80);
            backgroundMP.start();
        }
    }

    public static void setAlertNotification(Activity act) {

        dismissLoading();
        if (MainController.connectionAvailable(act)) {

//            setAlertDialog(act, "","No Record Found " , "" , "");
            setAlertDialog(act, "No Record Found");
        } else {

            setAlertDialog(act, "No Internet Connection");

//            setAlertDialog(act, "No Connection", "");
        }
    }

    public static void dismissLoading() {

//        if (pDialog != null) {
//            if (pDialog.isShowing()) {
//                pDialog.dismiss();
//                Log.e("Dismiss", "Y");

        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
                Log.e("Dismiss", "Y");
            }
        }
        Log.e("Dismiss", "N");
    }

    public static void initiateLoading(Activity act) {

//        if (pDialog != null) {
//            try {
//                pDialog.dismiss();
//            } catch (Exception e) {
//
////        s
//
//            }
//        }
//        pDialog = new SweetAlertDialog(act, SweetAlertDialog.PROGRESS_TYPE);
//        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//        pDialog.setTitleText("Loading");
//        pDialog.setCancelable(false);
//        pDialog.show();
        progressDialog = new ProgressDialog(act);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public static void setAlertDialog(final Activity act, String title  ) {

        if (act != null) {
            if (!act.isFinishing()) {


//                new MaterialDialog.Builder(act)
//
////                        .title(title)
////                        .titleGravity(GravityEnum.CENTER)
//                        .icon(R.drawable.calendar)
//                        .contentGravity(GravityEnum.CENTER)
//                        .content(title)
//                        .show();

                new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText(title)
                       // .setContentText(msg)
                        .show();

            }
        }
    }


}

package com.intranet.app;

import android.app.Activity;

import com.intranet.app.base.BaseFragment;
import com.intranet.app.utils.Utils;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainController extends BaseFragment {

    private static boolean homeStatus;

    private static SweetAlertDialog pDialog;

    public static boolean getRequestStatus(String objStatus, String message, Activity act ) {

        Boolean status = false;
        if (objStatus.contains("OK") || objStatus.equals("Redirect")) {
            status = true;

        } else if (objStatus.equals("Error") || objStatus.equals("error_validation")) {
            status = false;
            setAlertDialog(act, message );

        }

        return status;

    }

    public static boolean connectionAvailable(Activity act) {

        Boolean internet;
        internet = Utils.isNetworkAvailable(act);

        return internet;
    }

}

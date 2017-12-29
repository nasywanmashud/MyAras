package com.intranet.app.ui.Activity.HomePage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;

import com.intranet.app.ui.Activity.Login.LoginActivity;
import com.intranet.app.ui.Activity.Makmal.MakmalActivity;
import com.intranet.app.ui.Activity.Nota.NotaActivity;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.NotaReceive;
import com.intranet.app.ui.Model.Request.NotaRequest;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.realm.RealmResults;


/**
 * This class allow user to log in the app
 */
public class HomePageFragment extends BaseFragment  {

    @Inject
    Presenter presenter;

    @Inject
    Bus bus;

    @Bind(R.id.nota)
    Button btnnota;

    @Bind(R.id.username)
    TextView username;

    @Bind(R.id.makmal)
    Button btnmakmal;

    private SharedPrefManager pref;

    public static HomePageFragment newInstance(Bundle bundle) {

        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainApplication.component(getActivity()).inject(this);
        RealmObjectController.clearCachedResult(getActivity());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();


        pref = new SharedPrefManager(getActivity());

//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        toolbar.setTitle("MAKMAL KAWALAN PROSES");
//        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
//        toolbar.setNavigationIcon(R.drawable.ic_logout);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               setlogout(getActivity());
//            }
//        });

//        HashMap<String, String> username1 = pref.getUsername();
//        final String username = username1.get(SharedPrefManager.USERNAME);
//        username.

        HashMap<String, String> stringObject = pref.getUsername();
        final String sobject = stringObject.get(SharedPrefManager.USERNAME);

        Gson gson = new Gson();
        LoginReceive obj = gson.fromJson(sobject , LoginReceive.class);
        Log.e("test" , obj.getUsername());

        username.setText(obj.getUsername());
//        username.setText(sobject);

        pref = new SharedPrefManager(getActivity());

        btnnota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notarequest();
            }
        });

        btnmakmal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent caomdandygdisayangi = new Intent(getActivity(), MakmalActivity.class);
                startActivity(caomdandygdisayangi);

            }
        });



        return view;
    }


    public void notarequest(){
        //requestapi
        initiateLoading(getActivity());
        NotaRequest nota = new NotaRequest();
        presenter.onNota(nota);
    }

    @Subscribe
    public  void notasuccess ( NotaReceive obj){
        dismissLoading();

        if(obj.getStatus().equals("True")){

            Intent in = new Intent(getActivity(), NotaActivity.class);
            String stringObject = new Gson().toJson(obj);
            pref.setstringObject(stringObject);

            startActivity(in);


        }

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
//                                getContext().finish();
//                                sDialog.dismissWithAnimation();
//                                deleteAppData();
                                Intent in = new Intent(getActivity() , LoginActivity.class);
                                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                getActivity().finish();
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

    public void toolbar(View v){
                Toolbar toolbar = (Toolbar)v.findViewById(R.id.toolbar);
           toolbar.setVisibility(View.GONE);
    }



    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        bus.register(this);

        RealmResults<CachedResult> result = RealmObjectController.getCachedResult(MainFragmentActivity.getContext());
        if (result.size() > 0) {

            Gson gson = new Gson();
            if (result.get(0).getCachedAPI() != null) {
                if (result.get(0).getCachedAPI().equals("Clock")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    LoginReceive obj = gson.fromJson(result.get(0).getCachedResult(), LoginReceive.class);
                    // onClockSuccess(obj);

//                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
//                    Log.e("CachedData", result.get(0).getCachedResult().toString());
//
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

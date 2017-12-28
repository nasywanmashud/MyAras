package com.intranet.app.ui.Activity.Daftar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.AnalyticsApplication;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.Login.LoginActivity;
import com.intranet.app.ui.Activity.NavTest.Main3Activity;
import com.intranet.app.ui.Model.Receive.DaftarReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Request.DaftarRequest;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class DaftarFragment extends BaseFragment implements Validator.ValidationListener {

    @Inject
    Presenter presenter;


    @Inject
    Bus bus;

    @NotEmpty(sequence = 1, messageResId = R.string.email_empty)
    @Email(sequence = 2, messageResId = R.string.email_invalid)
    @Order(1)
    @Bind(R.id.email)
    EditText txtemail;

    @NotEmpty(sequence = 1, messageResId = R.string.password_empty)
    @Order(2)
    @Bind(R.id.password)
    EditText txtpassword;

    @NotEmpty(sequence = 1, messageResId = R.string.nomatrik_empty)
//    @Email(sequence = 2, messageResId = R.string.nomatrik_invalid)
    @Order(3)
    @Bind(R.id.nomatrik)
    EditText txtnomatrik;

    @NotEmpty(sequence = 1, messageResId = R.string.username_empty)
//    @Email(sequence = 2, messageResId = R.string.email_invalid)
    @Order(4)
    @Bind(R.id.username)
    EditText txtusername;

    @NotEmpty(sequence = 1, messageResId = R.string.fullname_empty)
//    @Email(sequence = 2, messageResId = R.string.email_invalid)
    @Order(5)
    @Bind(R.id.fullname)
    EditText txtfullname;

    @Bind(R.id.logmasuk)
    TextView txtlogmasuk;

    @Bind(R.id.daftar)
    LinearLayout btndaftar;

    private SharedPrefManager pref;
    private static String MIXPANEL_TOKEN = AnalyticsApplication.getMixPanelToken();

    MixpanelAPI mixPanel;
    Realm realm;
    Activity act;

    private String email,password,nomatrik,namapenuh,username;
    private static Validator mValidator;

    public static DaftarFragment newInstance() {

        DaftarFragment fragment = new DaftarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = getActivity();

        MainApplication.component(getActivity()).inject(this);
        RealmObjectController.clearCachedResult(getActivity());

        // Validator
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mValidator.setValidationMode(Validator.Mode.BURST);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_register, container, false);
        ButterKnife.bind(this, view);

        realm = RealmObjectController.getRealmInstance(act);
        pref = new SharedPrefManager(getActivity());

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mValidator.validate();


            }
        });

        txtlogmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), LoginActivity.class);
                startActivity(in);
            }
        });


        return view;
    }


    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        /* Validation Failed - Toast Error */
        for (ValidationError error : errors) {
            View view = error.getView();
            view.setFocusable(true);
            view.requestFocus();

            /* Split Error Message. Display first sequence only */
            String message = error.getCollatedErrorMessage(act);
            String splitErrorMsg[] = message.split("\\r?\\n");

            // Display error messages
            if (view instanceof EditText) {
                ((EditText) view).setError(splitErrorMsg[0]);
            }
        }
    }

    @Override
    public void onValidationSucceeded() {
        /* Validation Success - Start send data to server */
        nomatrik = txtnomatrik.getText().toString();
        namapenuh = txtfullname.getText().toString();
        username = txtusername.getText().toString();
        password = txtpassword.getText().toString();
        email = txtemail.getText().toString();
        loginFromFragment(nomatrik,namapenuh,username,password,email);
        //projectname ( loginEmail , selectedproject);

    }

    public static void setAlertDialog(final Activity act ) {

        if (act != null) {
            if (!act.isFinishing()) {

                new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Nombor Matrik Anda Telah Di Daftar ")
                        // .setContentText(msg)
                        .show();
            }
        }
    }

    public static void berjaya(final Activity act ) {

        if (act != null) {
            if (!act.isFinishing()) {

                new SweetAlertDialog(act, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Pendaftaran Berjaya! ")
                        // .setContentText(msg)
                        .show();

            }
        }
    }


    public void loginFromFragment(String nomatrik, String  namapenuh , String username, String password , String email) {

        initiateLoading(getActivity());
        DaftarRequest loginData = new DaftarRequest();
        loginData.setNo_matrik(nomatrik);
        loginData.setPassword(password);
        loginData.setEmail(email);
        loginData.setUsername(username);
        loginData.setName_penuh(namapenuh);

        presenter.onDaftar(loginData);

    }


    @Subscribe
    public void onLoginSuccess(DaftarReceive obj) {
         dismissLoading();

//
        if (obj.getStatus().equals("False") ) {

            setAlertDialog(getActivity());
        }

          else {

            berjaya(getActivity());
//            Intent in = new Intent(getActivity(), LoginActivity.class);
//            getActivity().finish();
//            startActivity(in);

        }



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
                if (result.get(0).getCachedAPI().equals("UserLogin")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    DaftarReceive obj = gson.fromJson(result.get(0).getCachedResult(), DaftarReceive.class);
                    onLoginSuccess(obj);

                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    loginFromFragment(nomatrik,namapenuh,username,password,email);


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

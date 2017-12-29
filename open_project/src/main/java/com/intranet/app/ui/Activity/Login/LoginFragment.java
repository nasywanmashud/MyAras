package com.intranet.app.ui.Activity.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.AnalyticsApplication;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.Daftar.DaftarActivity;
import com.intranet.app.ui.Activity.HomePage.HomePageActivity;
import com.intranet.app.ui.Activity.NavTest.Main3Activity;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Presenter.Presenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
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
public class LoginFragment extends BaseFragment implements Validator.ValidationListener {

    @Inject
    Presenter presenter;


    @Inject
    Bus bus;

    @NotEmpty(sequence = 1, messageResId = R.string.email_empty)
   // @Email(sequence = 2, messageResId = R.string.email_invalid)
    @Order(1)
    @Bind(R.id.txtLoginEmail)
    EditText txtLoginEmail;

    @NotEmpty(sequence = 1, messageResId = R.string.password_empty)
    @Order(2)
    @Bind(R.id.txtLoginPassword)
    EditText txtLoginPassword;

    @Bind(R.id.btnLogin)
    LinearLayout btnLogin;

    @Bind(R.id.daftar)
    TextView txtdaftar;


    private SharedPrefManager pref;
    private static String MIXPANEL_TOKEN = AnalyticsApplication.getMixPanelToken();

    MixpanelAPI mixPanel;
    Realm realm;
    Activity act;

    private String loginEmail;
    private String loginPassword;
    private static Validator mValidator;

    public static LoginFragment newInstance() {

        LoginFragment fragment = new LoginFragment();
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

        View view = inflater.inflate(R.layout.login, container, false);
        ButterKnife.bind(this, view);

        realm = RealmObjectController.getRealmInstance(act);
        pref = new SharedPrefManager(getActivity());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mValidator.validate();


            }
        });

        txtdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), DaftarActivity.class);
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
        loginEmail = txtLoginEmail.getText().toString();
        loginPassword = txtLoginPassword.getText().toString();
        loginFromFragment(txtLoginEmail.getText().toString(), txtLoginPassword.getText().toString());
        //projectname ( loginEmail , selectedproject);

    }

    public void loginFromFragment(String nomatrik, String password) {

        initiateLoading(getActivity());
        LoginRequest loginData = new LoginRequest();
        loginData.setNo_matrik(nomatrik);
        loginData.setPassword(password);

        presenter.onLogin(loginData);

    }


    @Subscribe
    public void onLoginSuccess(LoginReceive obj) {
         dismissLoading();

//
        if (obj.getStatus().equals("True") ) {

            //
                pref.setLoginStatus("true");
//                pref.setUsername(obj.getUsername());

            String stringObject = new Gson().toJson(obj);
            pref.setUsername(stringObject);

            Intent next = new Intent(getActivity(), Main3Activity.class);
//            Intent next = new Intent(getActivity(), HomePageActivity.class);
            getActivity().finish();
            startActivity(next);

        } else if (obj.getStatus().equals("nomatrik")){

            nomatrik(getActivity());


        }

          else if (obj.getStatus().equals("katalaluan")){

                katalaluan(getActivity());


    }

          else {


        }



    }
    public static void nomatrik(final Activity act ) {

        if (act != null) {
            if (!act.isFinishing()) {

                new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Nombor Matrik salah")
                        // .setContentText(msg)
                        .show();
            }
        }
    }

    public static void katalaluan(final Activity act ) {

        if (act != null) {
            if (!act.isFinishing()) {

                new SweetAlertDialog(act, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Kata Laluan salah")
                        // .setContentText(msg)
                        .show();

            }
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
                    LoginReceive obj = gson.fromJson(result.get(0).getCachedResult(), LoginReceive.class);
                    onLoginSuccess(obj);

                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    loginFromFragment(loginEmail, loginPassword);


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

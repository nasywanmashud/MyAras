package com.intranet.app.api;

import android.content.Context;
import android.util.Log;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.DaftarReceive;
import com.intranet.app.ui.Model.Receive.DetailNotaReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.NotaReceive;
import com.intranet.app.ui.Model.Request.DaftarRequest;
import com.intranet.app.ui.Model.Request.DetailNotaRequest;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Model.Request.NotaRequest;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ApiRequestHandler {

    @Inject
    ApiService apiService;

    @Inject
    Bus bus;

    public ApiRequestHandler(Context context) {
        MainApplication.get(context).getNetComponent().inject(this);
    }


    @Subscribe
    public void onLoginRequest(final LoginRequest event) {

        apiService.onRequestToLogin(event, new Callback<LoginReceive>() {

            @Override
            public void success(LoginReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LoginReceive(rhymesResponse));
                    //RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "UserLogin");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
              //  Log.e("error", "pape2");

            }

        });
    }

    @Subscribe
    public void onNotaRequest(final NotaRequest event) {

        apiService.onRequestToNota(event, new Callback<NotaReceive>() {

            @Override
            public void success(NotaReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new NotaReceive(rhymesResponse));
                    //RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "UserLogin");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                //  Log.e("error", "pape2");

            }

        });
    }

    @Subscribe
    public void onDaftarRequest(final DaftarRequest event) {

        apiService.onRequestToDaftar(event, new Callback<DaftarReceive>() {

            @Override
            public void success(DaftarReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new DaftarReceive(rhymesResponse));
                    //RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "UserLogin");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                //  Log.e("error", "pape2");

            }

        });
    }

    @Subscribe
    public void onDetailNotaRequest(final DetailNotaRequest event) {

        apiService.onRequestToDetailNota(event, new Callback<DetailNotaReceive>() {

            @Override
            public void success(DetailNotaReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new DetailNotaReceive(rhymesResponse));
                    //RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "UserLogin");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                //  Log.e("error", "pape2");

            }

        });
    }


    }


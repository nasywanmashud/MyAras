package com.intranet.app.ui.Presenter;

import android.content.Context;

import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.application.MainApplication;

import com.intranet.app.ui.Model.Request.DaftarRequest;
import com.intranet.app.ui.Model.Request.DetailNotaRequest;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Model.Request.NotaRequest;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class Presenter {

    @Inject
    ApiRequestHandler apiRequestHandler;

    @Inject
    Bus bus;

    public Presenter(Context context) {
        MainApplication.component(context).inject(this);
    }

    public void onResume() {
        bus.register(this);
    }

    public void onPause() {
        bus.unregister(this);
    }

    public void onLogin(LoginRequest data) {
        apiRequestHandler.onLoginRequest(data);
    }

    public void onDaftar(DaftarRequest data) {
        apiRequestHandler.onDaftarRequest(data);
    }

    public void onNota(NotaRequest data) {
        apiRequestHandler.onNotaRequest(data);
    }

    public void onDetailNota(DetailNotaRequest data) {
        apiRequestHandler.onDetailNotaRequest(data);
    }


}

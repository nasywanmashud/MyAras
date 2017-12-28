package com.intranet.app.api;

import com.intranet.app.ui.Model.Receive.DaftarReceive;
import com.intranet.app.ui.Model.Receive.DetailNotaReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.NotaReceive;
import com.intranet.app.ui.Model.Request.DaftarRequest;
import com.intranet.app.ui.Model.Request.DetailNotaRequest;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Model.Request.NotaRequest;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface  ApiService {


    //LOGIN
    @POST("/test/Laravel/public/login")
    void onRequestToLogin(@Body LoginRequest task, Callback<LoginReceive> callback);

    //NOTA
    @POST("/test/Laravel/public/nota")
    void onRequestToNota(@Body NotaRequest task, Callback<NotaReceive> callback);

    //daftar
    @POST("/test/Laravel/public/daftar")
    void onRequestToDaftar(@Body DaftarRequest task, Callback<DaftarReceive> callback);

    //daftar
    @POST("/test/Laravel/public/detail_nota")
    void onRequestToDetailNota(@Body DetailNotaRequest task, Callback<DetailNotaReceive> callback);


}



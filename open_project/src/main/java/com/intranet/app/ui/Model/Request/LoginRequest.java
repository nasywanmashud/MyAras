package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class LoginRequest {

    /*Local Data Send To Server*/
    String no_matrik;
    String password;

    public String getNo_matrik() {
        return no_matrik;
    }

    public void setNo_matrik(String no_matrik) {
        this.no_matrik = no_matrik;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //String mobile;


    /*Initiate Class*/
    public LoginRequest() {


    }

    public LoginRequest(LoginRequest data) {

      //  mobile = data.getMobile();
        no_matrik = data.getNo_matrik();
        password = data.getPassword();

    }
}
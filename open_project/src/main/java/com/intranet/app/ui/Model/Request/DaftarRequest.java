package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class DaftarRequest {

    /*Local Data Send To Server*/
    String username;
    String no_matrik;
    String name_penuh;
    String email;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName_penuh() {
        return name_penuh;
    }

    public void setName_penuh(String name_penuh) {
        this.name_penuh = name_penuh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



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
    public DaftarRequest() {


    }

    public DaftarRequest(DaftarRequest data) {

      //  mobile = data.getMobile();
        no_matrik = data.getNo_matrik();
        password = data.getPassword();
        name_penuh = data.getName_penuh();
        username = data.getUsername();
        email = data.getEmail();

    }
}
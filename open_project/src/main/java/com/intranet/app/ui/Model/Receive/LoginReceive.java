package com.intranet.app.ui.Model.Receive;

public class LoginReceive {

    String Status;
    String  Username;
    String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }


    public LoginReceive(LoginReceive returnData) {

        Username = returnData.getUsername();
        Status = returnData.getStatus();
        Email = returnData.getEmail();


    }



}

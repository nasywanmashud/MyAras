package com.intranet.app.ui.Model.Receive;

public class DaftarReceive {

    String Status;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public DaftarReceive(DaftarReceive returnData) {
        
        Status = returnData.getStatus();


    }



}

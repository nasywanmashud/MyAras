package com.intranet.app.ui.Model.Receive;

import java.util.ArrayList;

public class DetailNotaReceive {

    String Status;
    String Tajuk;
    String Content;



    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getTajuk() {

        return Tajuk;
    }

    public void setTajuk(String tajuk) {
        Tajuk = tajuk;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public DetailNotaReceive(DetailNotaReceive obj) {

        Status = obj.getStatus();
        Tajuk = obj.getTajuk();
        Content = obj.getContent();

    }
}


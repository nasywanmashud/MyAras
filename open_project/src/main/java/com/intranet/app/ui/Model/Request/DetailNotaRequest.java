package com.intranet.app.ui.Model.Request;

/**
 * Created by Dell on 11/4/2015.
 */
public class DetailNotaRequest {

    /*Local Data Send To Server*/
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*Initiate Class*/
    public DetailNotaRequest() {

    }

    public DetailNotaRequest(DetailNotaRequest data) {

      //  mobile = data.getMobile();
        id = data.getId();

    }
}
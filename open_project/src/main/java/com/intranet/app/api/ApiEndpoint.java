package com.intranet.app.api;

import retrofit.Endpoint;

public class ApiEndpoint implements Endpoint {

    @Override
    public String getUrl() {

        /*LIVE*/
        //return "https://appapi.airasiabig.com";
//        return "http://intranetapp.me-tech.com.my";

        /*STAGING*/

        return "http://10.0.2.2";
//        return "http://192.168.0.104";
        //} else {
            /*ret   urn "http://airasiabig2.me-tech.com.my";*/
        //}
        /*PREPRODAPI*/
        //return "http://stgappapi.tbdbig.com";

    }

    @Override
    public String getName() {
        return "Production Endpoint";
    }
}


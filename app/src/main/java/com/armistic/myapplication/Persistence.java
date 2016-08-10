package com.armistic.myapplication;

import com.loopj.android.http.*;

public class Persistence {

    private static final String BASE_URL = "http://entrevistas.pad.cl/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static AsyncHttpClient getClient() {
        return client;
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {

        // y ejecutamos la peticion.
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}

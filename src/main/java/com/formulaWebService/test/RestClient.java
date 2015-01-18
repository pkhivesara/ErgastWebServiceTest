package com.formulaWebService.test;


import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private static ApiCall REST_CLIENT;
    private static String URL =
            "http://ergast.com/api/";

    static {
        setupRestClient();
    }

    private RestClient() {}

    public static ApiCall get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(URL)
                .setClient(new OkClient(new OkHttpClient()));


        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(ApiCall.class);
    }
}


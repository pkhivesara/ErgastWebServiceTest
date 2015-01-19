package com.formulaWebService.test;


import retrofit.http.GET;
import retrofit.http.Path;

public interface ApiCall {

@GET("/f1/current/{round}.json")
  public ApiResponse getResult(@Path("round") String round);
}

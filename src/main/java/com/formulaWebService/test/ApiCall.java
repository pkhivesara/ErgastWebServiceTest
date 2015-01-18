package com.formulaWebService.test;


import retrofit.http.GET;
import retrofit.http.Query;

public interface ApiCall {

@GET("/f1/current")
  public ApiResponse getResult(@Query("round")String round);
}

package com.formulaWebService.test;


import retrofit.http.GET;

public interface ApiCall {

@GET("/f1/current/2.json")
  public MRData getResult();
}

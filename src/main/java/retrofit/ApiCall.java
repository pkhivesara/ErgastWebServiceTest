package retrofit;


import com.formulaWebService.test.ApiResponse;
import com.formulaWebService.test.DriverDetails;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ApiCall {

    @GET("/f1/current/{round}.json")
    public void getRoundDetail(@Path("round") String round, Callback callback);

    @GET("/f1/{season}/drivers.json")
    public void getDriverDetails(@Path("season") String season, @Query("limit") String limit, Callback callback);
}

package retrofit;


import com.formulaWebService.test.ApiResponse;
import com.formulaWebService.test.DriverDetails;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ApiCall {

    @GET("/f1/current/{round}.json")
    public ApiResponse getRoundDetail(@Path("round") String round);

    @GET("/f1/{season}/drivers.json")
    public DriverDetails getDriverDetails(@Path("season") String season, @Query("limit") String limit);
}

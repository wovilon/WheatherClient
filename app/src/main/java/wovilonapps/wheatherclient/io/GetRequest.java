package wovilonapps.wheatherclient.io;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import wovilonapps.wheatherclient.model.WeatherData;

public interface GetRequest {
    @GET("/{url}")
    Call<Object> GETMethodRequest(@Path("url") String url);


    /*@GET("/data/2.5/forecast?id=524901&APPID=d2a6b21c943e38d9e44edcc03c9912ad")
    Call<Object> GETMethodRequest();*/
}




package wovilonapps.wheatherclient.io;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import wovilonapps.wheatherclient.model.WeatherData;

public interface GetRequest {
    /*@GET("/data/2.5/forecast")
    Call<Object> GETMethodRequest(@Query("name") String resourceName);*/


    @GET("/data/2.5/forecast?q=London&cnt=7&APPID=d2a6b21c943e38d9e44edcc03c9912ad")
    Call<Object> GETMethodRequest();
}

//OK with Munchen
//url=http://samples.openweathermap.org/data/2.5/forecast/daily?q=M%C3%BCnchen,DE&appid=b1b15e88fa797225412429c1c50c122a1}


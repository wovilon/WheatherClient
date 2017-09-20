package wovilonapps.wheatherclient.io;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import wovilonapps.wheatherclient.model.WeatherData;

public interface SiteAPI {
    @GET("/users/{username}")
    Call<WeatherData> getWeatherr(@Path("username") String username);


}

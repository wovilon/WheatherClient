package wovilonapps.wheatherclient.io;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest {
    @GET("/ip")
    Call<Object> GETMethodRequest();
}




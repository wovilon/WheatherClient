package wovilonapps.wheatherclient.io;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface Link {
    //@FormUrlEncoded
    @POST("/post")
    Call<Object> post(@Body String string);
}

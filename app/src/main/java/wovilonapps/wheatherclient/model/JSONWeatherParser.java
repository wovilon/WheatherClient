package wovilonapps.wheatherclient.model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.Date;


public class JSONWeatherParser {
    private String jsonString;
    private JSONObject jsonObject;
    private ArrayList<MyWeather> weathers;
    private MyWeather weather;
    private String JSONSTUB;

    public JSONWeatherParser(String json){
        this.jsonString = json;
        try {
            jsonObject = new JSONObject(json);
        }catch (JSONException je){
            Log.d("MyLOG","JSONException in JSONWertherParser when creating JSON");}
        weathers = new ArrayList<>();

    }

     public ArrayList<MyWeather> processJson(){

         try {
             for (int i=0; i<jsonObject.getJSONArray("list").length(); i++){
            //parsing JSON and fillng weather object
             weather = new MyWeather();
             weather.setTemp_max(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONObject("main").getDouble("temp_max"));

             weather.setTemp_min(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONObject("main").getDouble("temp_min"));

             weather.setCloudsIconId(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONArray("weather").getJSONObject(0).getString("icon"));

             weather.setClouds(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONArray("weather").getJSONObject(0).getString("description"));

             weather.setWindSpeed(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONObject("wind").getDouble("speed"));

             weather.setWindDirection(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getJSONObject("wind").getDouble("deg"));

             weather.setDate(new Date(jsonObject.getJSONArray("list").getJSONObject(i)
                     .getLong("dt") * 1000));

             weathers.add(weather);
             }
         }catch (JSONException jse) {
             Log.d("MyLOG","JSONException in JSONWeatherParser.processJson when processing");
         }
        return weathers;
    }

    private void getJsonStub(){
        JSONSTUB = "{\"cod\":\"200\",\"message\":0.0161,\"cnt\":7,\"list\":[{\"dt\":1506070800,\"main\":{\"temp\":16.42,\"temp_min\":13.03,\"temp_max\":16.42,\"pressure\":1027.78,\"sea_level\":1035.32,\"grnd_level\":1027.78,\"humidity\":86,\"temp_kf\":3.39},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.76,\"deg\":258},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-09-22 09:00:00\"},{\"dt\":1506081600,\"main\":{\"temp\":18.32,\"temp_min\":15.77,\"temp_max\":18.32,\"pressure\":1027.74,\"sea_level\":1035.28,\"grnd_level\":1027.74,\"humidity\":77,\"temp_kf\":2.55},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.26,\"deg\":226.004},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-09-22 12:00:00\"},{\"dt\":1506092400,\"main\":{\"temp\":18.05,\"temp_min\":16.35,\"temp_max\":18.05,\"pressure\":1027.31,\"sea_level\":1034.83,\"grnd_level\":1027.31,\"humidity\":68,\"temp_kf\":1.7},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.91,\"deg\":222.001},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-09-22 15:00:00\"},{\"dt\":1506103200,\"main\":{\"temp\":15.1,\"temp_min\":14.25,\"temp_max\":15.1,\"pressure\":1027.59,\"sea_level\":1035.19,\"grnd_level\":1027.59,\"humidity\":67,\"temp_kf\":0.85},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":32},\"wind\":{\"speed\":2.81,\"deg\":214.504},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-09-22 18:00:00\"},{\"dt\":1506114000,\"main\":{\"temp\":12.59,\"temp_min\":12.59,\"temp_max\":12.59,\"pressure\":1028.53,\"sea_level\":1036.21,\"grnd_level\":1028.53,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":32},\"wind\":{\"speed\":2.87,\"deg\":207.501},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-09-22 21:00:00\"},{\"dt\":1506124800,\"main\":{\"temp\":11.15,\"temp_min\":11.15,\"temp_max\":11.15,\"pressure\":1028.72,\"sea_level\":1036.42,\"grnd_level\":1028.72,\"humidity\":89,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":36},\"wind\":{\"speed\":2.65,\"deg\":205.5},\"rain\":{\"3h\":0.005},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-09-23 00:00:00\"},{\"dt\":1506135600,\"main\":{\"temp\":11.39,\"temp_min\":11.39,\"temp_max\":11.39,\"pressure\":1028.22,\"sea_level\":1035.87,\"grnd_level\":1028.22,\"humidity\":92,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":2.31,\"deg\":180.009},\"rain\":{\"3h\":0.225},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-09-23 03:00:00\"}],\"city\":{\"id\":2643743,\"name\":\"London\",\"coord\":{\"lat\":51.5085,\"lon\":-0.1258},\"country\":\"GB\"}}";
    }
}

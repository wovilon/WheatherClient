package wovilonapps.wheatherclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import wovilonapps.wheatherclient.binders.ViewBinder;
import wovilonapps.wheatherclient.model.MyWeather;

//activity for week weather forecast
public class WeekWeatherActivity extends AppCompatActivity {
    ArrayList<MyWeather> weathers;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_weather);

        weathers = (ArrayList<MyWeather>) getIntent().getExtras().getSerializable("weathers");
        listView = (ListView)findViewById(R.id.weekWeatherListWiew);

        //preparing simpleAadapter for listview
        String date = "date";
        String temp_max = "temp_max";
        String temp_min = "temp_min";
        String clouds = "clouds";
        String windSpeed = "wind_speed";
        String windDirection = "wind_direction";

        ArrayList<Map<String,Object>> data = new ArrayList<>();
        Map<String, Object> m;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, hh:mm a", Locale.ENGLISH);

        for (int i=0; i<weathers.size(); i++){
            m = new HashMap<>();
            m.put(date, dateFormat.format(weathers.get(i).getDate()));
            m.put(temp_max, Math.round(weathers.get(i).getTemp_max()) + "\u00B0C");
            m.put(temp_min, Math.round(weathers.get(i).getTemp_min()) + "\u00B0C");
            m.put(clouds, getCloudsIcon(weathers.get(i).getCloudsIconId()));
            m.put(windSpeed, weathers.get(i).getWindSpeed());
            m.put(windDirection,rotateBitmap(
                    BitmapFactory.decodeResource(getResources(), R.drawable.wind_arrow),
                    (float) weathers.get(i).getWindDirection()) );
            data.add(m);
        }

        String[] from = {date, temp_max, temp_min, clouds, windSpeed, windDirection};
        int[] to = {R.id.Date, R.id.maxValue, R.id.minValue, R.id.Clouds, R.id.WindValue, R.id.windDirection};

        final SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.week_weather_item, from, to);
        adapter.setViewBinder(new ViewBinder());
        listView.setAdapter(adapter);

    }
    //get recource ny id, if null - no icon, not exception
    private Bitmap getCloudsIcon(String id){
        int res = getResources().getIdentifier("ic"+id, "drawable", getPackageName());
        return BitmapFactory.decodeResource(getResources(), res);
    }

    //abjust wird dicection icon
    public static Bitmap rotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

}

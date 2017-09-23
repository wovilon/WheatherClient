package wovilonapps.wheatherclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import wovilonapps.wheatherclient.binders.ViewBinder;
import wovilonapps.wheatherclient.io.MyWeather;

public class WeekWeatherActivity extends AppCompatActivity {
    ArrayList<MyWeather> weathers;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_weather);

        weathers = (ArrayList<MyWeather>) getIntent().getExtras().getSerializable("weathers");

        listView = (ListView)findViewById(R.id.weekWeatherListWiew);

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

    private Bitmap getCloudsIcon(String id){
        Bitmap bitmap;
        if (id.equals("ic01d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic01d);
        else if (id.equals("ic02d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic02d);
        else if (id.equals("ic03d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic03d);
        else if (id.equals("ic04d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic04d);
        else if (id.equals("ic09d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic09d);
        else if (id.equals("ic10d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic10d);
        else if (id.equals("ic11d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic11d);
        else if (id.equals("ic13d")) bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic13d);
        else bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic50d);


        return bitmap;
    }

    public static Bitmap rotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

}

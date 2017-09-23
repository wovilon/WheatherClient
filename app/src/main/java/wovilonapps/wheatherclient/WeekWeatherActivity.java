package wovilonapps.wheatherclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import wovilonapps.wheatherclient.io.MyWeather;
import wovilonapps.wheatherclient.io.Weather;

public class WeekWeatherActivity extends AppCompatActivity {
    ArrayList<MyWeather> weathers;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_weather);

        weathers = (ArrayList<MyWeather>) getIntent().getExtras().getSerializable("weathers");

        listView = (ListView)findViewById(R.id.weekWeatherListWiew);

        String caption = "Date";
        String temp_max = "temp_max";
        String temp_min = "temp_min";
        /*
        ArrayList<Map<String,Object>> data = new ArrayList<>();
        Map<String, Object> m;
        CarModels carModels = new CarModels(this);

        for (int i=0; i<carModels.getAllCars().size(); i++){
            m = new HashMap<>();
            m.put(caption, carModels.getAllCars().get(i).model);
            m.put(image, carModels.getAllCars().get(i).carBitmap);
            data.add(m);
        }

        String[] from = {caption, image};
        int[] to = {R.id.itemCaption, R.id.itemImage};

        final SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.cars_list_item, from, to);
        adapter.setViewBinder(new ViewBinder());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                returnResult(i);
            }
        });*/
    }
}

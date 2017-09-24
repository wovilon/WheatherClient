package wovilonapps.wheatherclient;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import wovilonapps.wheatherclient.binders.ViewBinder;
import wovilonapps.wheatherclient.db.DbUpdator;
import wovilonapps.wheatherclient.io.MyWeather;
// frag
public class CityListFragment extends Fragment {
    ArrayList<String> cities;
    ListView listView;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_city_list, container, false);

        fillListView(view);
        return view;
    }

    private void fillListView(View view){
        cities = new DbUpdator(getActivity()).getAllCitiesFromDb();

        listView = (ListView) view.findViewById(R.id.savedCitiesListView);

        String city = "city";

        ArrayList<Map<String,String>> data = new ArrayList<>();
        Map<String, String> m;

        for (int i=0; i<cities.size(); i++){
            m = new HashMap<>();
            m.put(city, cities.get(i));
            data.add(m);
        }

        String[] from = {city};
        int[] to = {R.id.cityForList};

        final SimpleAdapter adapter = new SimpleAdapter(getActivity(), data, R.layout.city_list_item, from, to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DbUpdator dbUpdator = new DbUpdator(getActivity());
                String city = dbUpdator.getCityFromDb(i);
                ((MainActivity) getActivity()).useGetMethod(city);
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            fillListView(view);
        }
        else {
        }
    }
}

package wovilonapps.wheatherclient;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TabHost;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import wovilonapps.wheatherclient.adapters.ViewPagerAdapter;
import wovilonapps.wheatherclient.io.GetRequest;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    //Restofit part of variables
    private String URL;
    private String KEY;
    private Gson gson;
    //"get"request
    //private Gson gson=new GsonBuilder().create();
    private Retrofit retrofit_get;
    private GetRequest interf_get;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adding tabs
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        //describe Retrofit variables
        URL = getString(R.string.URLBase);
        KEY = getResources().getString(R.string.KEY);
        gson = new GsonBuilder().create();
        retrofit_get = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(URL)
                .build();
        interf_get = retrofit_get.create(GetRequest.class);

        useGetMethod("/data/2.5/forecast?id=524901&APPID=d2a6b21c943e38d9e44edcc03c9912ad");

    }

    //setup page sweeper
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CityFragment(), "People");
        adapter.addFragment(new CityListFragment(), "Group");
        viewPager.setAdapter(adapter);
    }

    //get weather by city
    public void useGetMethod(String url) {
        Call<Object> call = interf_get.GETMethodRequest(url);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response1) {
                try {
                    Log.d("MyLOG", response1.toString());
                    Log.d("MyLOG", "response body: " + response1.body().toString());
                }catch (NullPointerException npe) {Log.d("MyLOG", "NullPointerException at useGerMethod()");}
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("MyLOG", "CallBack onFailture: " + t.toString());
            }
        });
    }

    public void makeRequest(String city){
        String url = "/data/2.5/forecast/daily?q=London&mode=xml&units=metric&cnt=7";
        useGetMethod(url);
    }

}

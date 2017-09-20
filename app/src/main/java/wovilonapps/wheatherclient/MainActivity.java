package wovilonapps.wheatherclient;

import android.app.TabActivity;
import android.content.Intent;
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

    //Restofit part of vriables
    private final String URL = "https://httpbin.org";
    private final String KEY="trnsl.1.1.20170804T122548Z.3ca77883be4adf6a.3ed6b8d4d8e3e1f0538bc85d5fe7b8283492412800";
    private Gson gson=new GsonBuilder().create();
    //get request
    //private Gson gson=new GsonBuilder().create();
    private Retrofit retrofit_get=new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(URL)
            .build();
    private GetRequest interf_get = retrofit_get.create(GetRequest.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adding tabs
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        useGetMethod();

    }

    //setup page sweeper
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CityFragment(), "People");
        adapter.addFragment(new CityListFragment(), "Group");
        viewPager.setAdapter(adapter);
    }


    public void useGetMethod() {
        Call<Object> call = interf_get.GETMethodRequest();
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response1) {
                Log.d("MyLOG", response1.toString());
                Log.d("MyLOG", "response body: " + response1.body().toString());
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("MyLOG", "CallBack onFailture: " + t.toString());
            }
        });
    }
}

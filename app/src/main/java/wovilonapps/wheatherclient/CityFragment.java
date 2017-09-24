package wovilonapps.wheatherclient;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class CityFragment extends Fragment {
    Button buttonGetWeather;
    EditText editTextCity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_city, container, false);

        editTextCity = (EditText)view.findViewById(R.id.editText);
        buttonGetWeather = (Button) view.findViewById(R.id.buttonGetWeather);
        buttonGetWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).useGetMethod(editTextCity.getText().toString());
            }
        });

        return view;
    }



}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Tag;

public class FragmentHome_R extends Fragment {
    private TextView received_NAME, received_EMAIL, received_PASSWORD;
    private Button MAP_button, API_CAll;

    private static final String TAG = "Home_R";

    public FragmentHome_R() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home__r, container, false);
        received_NAME = (TextView)v. findViewById(R.id.received_name);
        received_EMAIL = (TextView)v. findViewById(R.id.received_email);
        received_PASSWORD = (TextView)v. findViewById(R.id.received_password);
        MAP_button = (Button)v. findViewById(R.id.maps);
        API_CAll = (Button)v.findViewById(R.id.APICALL);

        Bundle extras = getActivity().getIntent().getExtras();
        String NAME = extras.getString("name");
        String EMAIL = extras.getString("email");
        String PASSWORD = extras.getString("password");
        received_NAME.setText(NAME);
        received_EMAIL.setText(EMAIL);
        received_PASSWORD.setText(PASSWORD);

//          Intent intent = getIntent();

        API_CAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            AsfandMethods methods = AsfandRetrofitClient.getRetrofitInstance().create(AsfandMethods.class);
                Call<AsfandModel> call = methods.getAllData();

                call.enqueue(new Callback<AsfandModel>() {
                    @Override
                    public void onResponse(Call<AsfandModel> call, Response<AsfandModel> response) {
                        Log.e(TAG, "onResponse: code: "+ response.code());

                        ArrayList<AsfandModel.data> data = response.body().getData();
                        for (AsfandModel.data data1 :data)
                        {
                            Log.e(TAG,"onResponse: names : "+ data1.getName());

                        }

                    }

                    @Override
                    public void onFailure(Call<AsfandModel> call, Throwable t) {
                        Log.e(TAG,"onFailure:"+ t.getMessage());

                    }
                });

            }
        });

        MAP_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MapActivity.class);
                startActivity(i);
            }
        });
    return v;

    }
}
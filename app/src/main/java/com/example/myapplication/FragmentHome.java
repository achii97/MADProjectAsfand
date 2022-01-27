package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentHome extends Fragment {

    private Button Register_button;


    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.fragment_home, container, false);
        Register_button = (Button)V.  findViewById(R.id.RegisterButton);
        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });

        return V;
    }

    public void openRegisterActivity()
    {
        Intent intent = new Intent(getActivity(),RegisterActivity.class);
        startActivity(intent);

    }

}
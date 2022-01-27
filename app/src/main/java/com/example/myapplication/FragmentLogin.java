package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentLogin extends Fragment {

    private Button Submit_button;
    private EditText NAME, EMAIL, PASSWORD, REPASSWORD;


    public FragmentLogin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        /// getting values via ids
        NAME = (EditText)v. findViewById(R.id.name);
        EMAIL = (EditText)v. findViewById(R.id.email);
        PASSWORD = (EditText)v. findViewById(R.id.password);
        REPASSWORD  = (EditText)v. findViewById(R.id.repassword);
        Submit_button = (Button)v.  findViewById(R.id.SubmitButton);

        // assigning user input to variables
        String user_input_name = NAME.getText().toString();
        String user_input_email = EMAIL.getText().toString();
        String user_input_password = PASSWORD.getText().toString();
        String user_input_repassword = REPASSWORD.getText().toString();

        Submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                intent.putExtra("name", user_input_name);
                intent.putExtra("email", user_input_email);
                intent.putExtra("password", user_input_password);
                startActivity(intent);
               // openLoginActivity();
            }
        });
        return v;

    }
}
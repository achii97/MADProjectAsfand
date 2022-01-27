package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;




public class APICALL extends AppCompatActivity {

    private TextView test;

    public String APICALLFUNC(URL url)
    {
//        HttpURLConnection connection = null;

        try {

//            //Create connection
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Content-Type",
//                    "application/json");
//
////            connection.setRequestProperty("Content-Length",
////                    Integer.toString(urlParameters.getBytes().length));
////            connection.setRequestProperty("Content-Language", "en-US");
//            connection.setRequestProperty("Accept","application/json");
////            connection.setUseCaches(false);
////            connection.setDoOutput(true);
//
//            //Send request
//            DataOutputStream wr = new DataOutputStream(
//                    connection.getOutputStream());
////            wr.writeBytes(urlParameters);
//            wr.close();
//
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//            String line;
//            while ((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();


//            URL url = new URL("https://api.covid19api.com/summary");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setRequestProperty("Accept", "application/json");
            System.out.println("message before connect");

            conn.connect();
            System.out.println("message in connect");


            //Check if connect is made
            int responseCode = conn.getResponseCode();
//            String msg = conn.getResponseMessage();
//            System.out.println("message = " + msg);
            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                System.out.println(informationString);


//                JSON simple library Setup with Maven is used to convert strings to JSON
//                JSONParser parse = new JSONParser();
//                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
//
//                Get the first JSON object in the JSON array
//                System.out.println(dataObject.get(0));
//
//                JSONObject countryData = (JSONObject) dataObject.get(0);
//
//                System.out.println(countryData.get("woeid"));

                return informationString.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error = "+ e.toString());
            return null;
        }
//        finally {
//            if (conn != null) {
//                conn.disconnect();
//            }
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicall);
        test = (TextView)findViewById(R.id.Test);


        String EndPoint = "https://c-company.herokuapp.com/api/v1/getCompanies";
        URL url = null;
        try {
            url = new URL(EndPoint);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("URL = "+ url);
        String response = APICALLFUNC(url);

        System.out.println("Response from API = " + response);
        System.out.println("Response should come");

        if (response == null)
        {
            test.setText("Data = Null");
        }
        else {
            test.setText(response);

        }


    }
}
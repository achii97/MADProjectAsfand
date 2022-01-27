package com.example.myapplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIMain {


    public String APICALL(URL url)
    {
        HttpURLConnection connection = null;

        try {
            //Create connection
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type",
                    "application/json");

//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("Accept","application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
//            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }




    public void main(String[] args) throws IOException, InterruptedException
    {
        String EndPoint = "https://c-company.herokuapp.com/api/v1/getCompanies";
        URL url = new URL(EndPoint);

       String response = APICALL(url);

       System.out.println("Response from API = " + response);

       // http request
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Content-Type", "application/json");
//        String ContentType = con.getHeaderField("Content-Type");
//
//        con.setConnectTimeout(5000);
//        con.setReadTimeout(5000);
//
//        int status = con.getResponseCode();
//
//
//        BufferedReader in = new BufferedReader(
//                new InputStreamReader(con.getInputStream()));
//
//        String InputLine;
//
//        StringBuffer content = new StringBuffer();
//
//        while ((InputLine = in.readLine())!= null)
//        {
//            content.append(InputLine);
//        }
//        in.close();
//
//        con.disconnect();








    }


}

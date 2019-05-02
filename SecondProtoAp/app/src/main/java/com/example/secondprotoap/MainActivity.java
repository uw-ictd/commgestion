package com.example.secondprotoap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.*;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        try{
            String message = serverMessage();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }catch(java.io.IOException e){
            String errorMessage = e.getMessage();
            intent.putExtra(EXTRA_MESSAGE, errorMessage);
            startActivity(intent);
        }
    }
    public String serverMessage() throws IOException {
        URL url = null;
        HttpURLConnection con = null;
        try {
            url = new URL("http://www.google.com");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            //InputStream is = con.getErrorStream();        //this line throws exception
            InputStream is = con.getInputStream();          // this line throws exception

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
        catch(Exception e){
            throw new java.io.IOException("exception thrown");
            }
            finally {
                if (con != null) {
                    con.disconnect();
            }
        }
    }

    public String serverMessage2() throws IOException {
        URL url = new URL("http://localhost:5000/test-http");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //readStream(in);

        } finally {
            urlConnection.disconnect();
        }
        return "something";
    }
}

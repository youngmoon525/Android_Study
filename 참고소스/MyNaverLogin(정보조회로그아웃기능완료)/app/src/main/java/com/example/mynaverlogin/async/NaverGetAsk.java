package com.example.mynaverlogin.async;

import android.net.http.AndroidHttpClient;
import android.net.http.HttpsConnection;
import android.os.AsyncTask;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NaverGetAsk extends AsyncTask<String,String,InputStream> {
    private static final String TAG = "common";

    HttpURLConnection connection; //url을 담을
    final String HTTPIP = "https://openapi.naver.com/v1/nid/me";//IP

    Map<String, String>  requestHeaders  = new HashMap<>();;
    public NaverGetAsk(String header ) {

        requestHeaders.put("Authorization", header);

    }

    @Override
    protected InputStream doInBackground(String... strings) {
        int responseCode = 0;
        try {
            connection = (HttpURLConnection) new URL(HTTPIP).openConnection();
            connection.setRequestMethod("GET");

        for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
            connection.setRequestProperty(header.getKey(), header.getValue());
        }
            responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try {
                return connection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }


}

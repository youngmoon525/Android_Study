package com.example.mozak.async;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommonAsk extends AsyncTask<String,String,InputStream> {
    private static final String TAG = "common";
    HttpClient httpClient;//접속을 위한객체
    HttpPost httpPost; //url을 담을 객체

    MultipartEntityBuilder builder;//파라메터,파일 등등을 보내기위한 객체
    final String HTTPIP = "http://192.168.0.29";    //IP
    final String SVRPATH = "/middle/"; //
    String mapping ;
    private String postUrl ;

    public ArrayList<AskParam> params ;

    public CommonAsk(String mapping) {
        this.mapping = mapping;
        params = new ArrayList<>();
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ;

        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addTextBody("index" , params.size() + "",
                ContentType.create("Multipart/related" , "UTF-8"));
        for(int i = 0; i< params.size(); i++){
            builder.addTextBody(params.get(i).getKey() , params.get(i).getValue() ,
                    ContentType.create("Multipart/related" , "UTF-8"));
        }

        httpClient = AndroidHttpClient.newInstance("Android");
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());//파라메터를 추가할수있는부분.
        InputStream   in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();


        } catch (IOException e) {
            e.printStackTrace();
        }
        //rtnString(in);
        return in;
    }

    public String rtnString(InputStream inputStream){
        try {


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        }catch (IOException e){

        }
        return "";
    }

}

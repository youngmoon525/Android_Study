package com.example.mozak.async;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.IOException;
import java.io.InputStream;


public class AskTest extends AsyncTask<String, String, String> {
    private static final String TAG = "common";
    HttpClient httpClient;          //접속을 위한 객체
    HttpPost httpPost;              //url을 담을 객체
    HttpResponse httpResponse;      //Middle ↔ And    //미사용
    HttpEntity httpEntity;          //속성을 정의함
    MultipartEntityBuilder builder; //파라메터, 파일 등등을 보내기 위한 객체★

    final String HTTPIP = "http://192.168.0.29";    //IP
    final String SVRPATH = "/middle/"; //
    private String postUrl;
    private String Mapping;

    public AskTest(String mapping) {
        Mapping = mapping;
    }

    @Override
    protected String doInBackground(String... strings) {
        //반복되는 소스가 어디서부터 어디까지 생기고
        //어떻게 하면 줄일 수 있을까?
        //무조건 InputStream 으로 무조건 return을 받음

        postUrl = HTTPIP + SVRPATH + Mapping;//크롬창에 요청했을 때 되는 mapping
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

        builder.addTextBody("data" , "datadata" ,
                ContentType.create("Multipart/related" , "UTF-8"));


        //========= 반복되는 부분 ↑ ======================================================


        httpClient = AndroidHttpClient.newInstance("Android");
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());//파라메터를 추가할수있는부분.
        InputStream   in = null;
        try {
            in = httpClient.execute(httpPost).getEntity().getContent();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

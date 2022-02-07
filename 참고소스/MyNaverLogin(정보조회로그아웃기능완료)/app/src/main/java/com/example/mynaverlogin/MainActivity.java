package com.example.mynaverlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.mynaverlogin.async.NaverGetAsk;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.NidOAuthLoginState;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.nhn.android.naverlogin.OAuthLogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    OAuthLogin authLogin ;
    NidOAuthLoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        authLogin = OAuthLogin.getInstance();
        authLogin.showDevelopersLog(true);
        authLogin.init(
                                MainActivity.this,
                "6NgszBarfIWi1c37D_7W",
                "fCFOMiNs9T",
                "myTestLogin"
        );


        loginButton = findViewById(R.id.naver_login);
        loginButton.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                String Authorization =  "Bearer " + authLogin.getAccessToken(MainActivity.this);
                NaverGetAsk ask = new NaverGetAsk(Authorization);

                InputStream in = null;
                try {
                    in = ask.execute().get();
                    readBody(in);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

              //  new RequestApiTask(MainActivity.this, authLogin).execute();
            }

            @Override
            public void onFailure(int i, String s) {

            }

            @Override
            public void onError(int i, String s) {

            }
        });
        
        findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NidOAuthLoginState.OK.equals(OAuthLogin.getInstance().getState(MainActivity.this))){
                    NidOAuthLogin aa = new NidOAuthLogin();
                    aa.logout();
                }
            }
        });

    }

    private String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);
        try(BufferedReader lineReader = new BufferedReader(streamReader)){
            StringBuilder responseBody = new StringBuilder();
            String line;
            while((line = lineReader.readLine()) != null){
                responseBody.append(line);
            }
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다. ", e);
        }
    }


}


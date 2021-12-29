package com.example.newlastproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.newlastproject.transactivity.TransActivity;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.kakao.sdk.user.model.Profile;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    EditText edt_id , edt_pw;
    Button btn_login;
    ImageView imgv_kakaologin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        KakaoSdk.init(this, "e766cd38a872d87544668acaec7d0407");

        Intent intent = new Intent(LoginActivity.this, TransActivity.class);
        startActivity(intent);

        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login = findViewById(R.id.btn_login);
        imgv_kakaologin = findViewById(R.id.imgv_kakaologin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // edt_id <- 글자 EditText.getText()<-
                if( (edt_id.getText()+"").equals("aaa") &&  (edt_pw.getText()+"").equals("aaa") ){
                    Toast.makeText(LoginActivity.this, "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "아이디,비밀번호 틀림.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //https://developers.kakao.com/docs/latest/ko/kakaologin/android
        //kotlin ↓ 자바로 바꿈
        Function2<OAuthToken , Throwable , Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null){
                    Toast.makeText(LoginActivity.this, "정보를 받아옴", Toast.LENGTH_SHORT).show();
                    getKakaoinfo();
                }
                if(throwable != null){
                    Toast.makeText(LoginActivity.this, "뭔가 오류가남.", Toast.LENGTH_SHORT).show();
                }
                
                return null;
            }
        };

        imgv_kakaologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                if(UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)){
                    Toast.makeText(LoginActivity.this, "카카오톡 설치 됨", Toast.LENGTH_SHORT).show();
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,callback);
                }else{
                    Toast.makeText(LoginActivity.this, "카카오톡 설치 안됨", Toast.LENGTH_SHORT).show();
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,callback);
                }
            }
        });

    }

    public void getKakaoinfo(){
        UserApiClient.getInstance().me( (user, throwable) -> {
            if(throwable != null){
                //오류가 났을때 어떤 오류인지 알아볼수가 있음 . KOE + 숫자
            }else{
                // [ {  }  ] json 구조처럼 바로 데이터가 있는게 아니라 Account라는 키로 한칸을 들어가고
                //여기안에서 또 profile이라는 칸으로 또 이동 .
                Account kakaoAcount = user.getKakaoAccount();
                if(kakaoAcount != null){
                    Profile profile = kakaoAcount.getProfile();
                    if(profile != null){
                        Toast.makeText(LoginActivity.this, profile.getNickname()+"님 환영", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            return  null;
        }) ;
    }

//// 카카오톡으로 로그인
//UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
//        if (error != null) {
//            Log.e(TAG, "로그인 실패", error)
//        }
//        else if (token != null) {
//            Log.i(TAG, "로그인 성공 ${token.accessToken}")
//        }
//    }




}
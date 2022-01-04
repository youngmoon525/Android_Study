package com.example.newlastproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.newlastproject.async.AskTest2;
import com.example.newlastproject.noti.NotiActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //1.Notify .. API 알람띄우기 ( 기기 고유값을 알고있는상태에서 WEB->Android )
    //2.지금 사용할 방법 ) Background서비스를 하나 만들고 계속해서 어플이 종료되도
    //서버에 있는 데이터를 수신할수있게 만들고나서 사용 <-  ?
    //3.버튼을 클릭했을때 알림이 나오게끔 처리
    NotificationManager manager; //상단에 툴바( 알람 )
    // 오레오 버전 ( API 26 ) 이후에는 현)대부분의 안드로이드폰 에서는
    // 이 알람을 띄우기 위한 별도의 알람 채널 , 채널이름이 필요함.
    final String CHANNEL_ID1 = "channel1";
    final String CHANNEL_NAME1 = "channel1";
    final String CHANNEL_ID2 = "channel2";
    final String CHANNEL_NAME2 = "channel2";
    final String CHANNEL_ID3 = "channel3";
    final String CHANNEL_NAME3 = "channel3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotiSimple();
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotiPending();
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotiBigText();
            }
        });
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AskTest2 askTest2 = new AskTest2("test");
                askTest2.params.add("id1");//param1
                askTest2.params.add("pw2");
                askTest2.params.add("pw3");
                askTest2.params.add("pw4");
                askTest2.params.add("pw5");
                askTest2.params.add("pw6");
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                askTest2.params.add("pw7");//param7
                //재활용 => ArrayList에 파라메터를 여러개 추가함.
                //여러개는 규칙적인 이름을가짐 ex) param1 ~ param10
                //파라메터의 갯수를 알고있다면 Spring에서도 갯수만큼 for문으로
                //req.getParameter("param" + i )
                //파라메터의 이름이 전부타 param + 숫자 이기때문에 어떤값이 들어있는지
                //잘생각하고 써야하는 단점이 있음
                askTest2.execute();
            }
        });
    }// oncreate()

    //단순한 알람 띄우기 기능을 담당함.
    private void showNotiSimple(){
        //알람을 띄우기 위해서 필요한것 ==> manager <- 전역변수로 만들어놓은(필드)
        //Fragment를 사용하는 이유 + ) Context라는것은(제어권) 많은 기능을 담은 서비스를 가지고있음.
        //액티비티를 많이 만든다는것은 많은 컨텍스트를 가지고 있을수밖에 없기때문에 Fragment를 사용하는것보다
        //느려짐.
        //1. manager 객체 초기화 하기 .
        manager = (NotificationManager) getSystemService(MainActivity.NOTIFICATION_SERVICE);
        //2. Noti알람 객체를 만들기 위한 Builder라는 객체가 필요함. 생성식이 오레오 이전과 이후로 나뉨.
        NotificationCompat.Builder builder = null; //↑
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //현재 버전이 Oreo이상인 상태에서 초기화식
            if(manager.getNotificationChannel(CHANNEL_ID1) == null){
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID1,
                        CHANNEL_NAME1,
                        NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
            builder = new NotificationCompat.Builder(MainActivity.this , CHANNEL_ID1);
        }else{
            builder = new NotificationCompat.Builder(MainActivity.this );//구버전
        }
        //Method 하나 추가 ↑ showNotiPending

        builder.setContentTitle("간단한 알람 제목")
                .setContentText("간단한 알람 내용을 쓰면됨")
                .setSmallIcon(android.R.drawable.ic_menu_view)
        ;
        Notification noti = builder.build();
        manager.notify(1,noti);


    }

    private void showNotiPending(){
        manager = (NotificationManager) getSystemService(MainActivity.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null; //↑
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //현재 버전이 Oreo이상인 상태에서 초기화식
            if(manager.getNotificationChannel(CHANNEL_ID2) == null){
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID2,
                        CHANNEL_NAME2,
                        NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
            builder = new NotificationCompat.Builder(MainActivity.this , CHANNEL_ID2);
        }else{
            builder = new NotificationCompat.Builder(MainActivity.this );//구버전
        }
        // 펜딩 인텐트 ? => Intent객체를 가지고있는 객체
        // 알람이나 OS에 바로 붙어있는 화면(프로세스)가 아닌 상태에서의 화면을 전환하기 위한 객체
        // 펜딩 인텐트는 특정한 상황에서 어떤 행동을 할지 미리 지정을 해놓는것
        Intent intent = new Intent(this, NotiActivity.class);
        // FLAG_UPDATE_CURRENT <= 기존의 펜딩인테트가 있다면 지금 만들고있는 Intent로 갈아 끼울것인지.
        PendingIntent pendingIntent = PendingIntent.getActivity( this, 1001 , intent
        , PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentTitle("펜딩 인텐트 제목")
                .setContentText("펜딩 인텐트 클릭을 해보세요,.")
                .setSmallIcon(android.R.drawable.ic_menu_delete)
                .setAutoCancel(true) //알람을 클릭하면 자동으로 알람이 사라질것인지 여부부
                .setContentIntent(pendingIntent);//클릭을 하면 발동할 PendingIntent를 넘겨줌

        Notification noti = builder.build();
        manager.notify(2 , noti);


   }


    private void showNotiBigText(){
        manager = (NotificationManager) getSystemService(MainActivity.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = null; //↑
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //현재 버전이 Oreo이상인 상태에서 초기화식
            if(manager.getNotificationChannel(CHANNEL_ID3) == null){
                manager.createNotificationChannel(new NotificationChannel(
                        CHANNEL_ID3,
                        CHANNEL_NAME3,
                        NotificationManager.IMPORTANCE_DEFAULT
                ));
            }
            builder = new NotificationCompat.Builder(MainActivity.this , CHANNEL_ID3);
        }else{
            builder = new NotificationCompat.Builder(MainActivity.this );//구버전
        }
        Intent intent = new Intent(this, NotiActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity( this, 1001 , intent
                , PendingIntent.FLAG_UPDATE_CURRENT);
        //글자가 긴 알람의경우에는 Style을 먼저 만들어야함.
        NotificationCompat.BigTextStyle style
                = new NotificationCompat.BigTextStyle();
        style.bigText("긴글자 긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자긴글자 ");
        style.setBigContentTitle("제목을 입력함.");
        style.setSummaryText("요약해서 보여줄 정보");

        builder = new NotificationCompat
                .Builder(this,CHANNEL_ID3)
                .setSmallIcon(android.R.drawable.ic_menu_view)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setStyle(style);


        Notification noti = builder.build();
        manager.notify(3 , noti);


    }








}
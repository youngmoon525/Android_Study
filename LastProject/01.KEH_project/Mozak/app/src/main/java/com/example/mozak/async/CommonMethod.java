package com.example.mozak.async;

import android.os.AsyncTask;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class CommonMethod {

    public static InputStream excuteAsk(AsyncTask<String, String, InputStream> ask){
        InputStream in = null;
        try {
            in = ask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return in;
    }
}

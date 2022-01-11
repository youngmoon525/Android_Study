package com.example.newlastproject.async;

import android.os.AsyncTask;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public class CommonMethod {
    static InputStream in = null;
    public static InputStream excuteAsk(AsyncTask<String,String,InputStream> ask){


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

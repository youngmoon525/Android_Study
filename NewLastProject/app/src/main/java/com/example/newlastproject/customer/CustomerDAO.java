package com.example.newlastproject.customer;

import android.content.Context;

import com.example.newlastproject.async.AskTest2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class CustomerDAO {
    AskTest2 service ;
    Context context;
    Gson gson = new Gson();
    public ArrayList<CustomerVO> list(){
        service = new AskTest2("list.cu");
        InputStream in = null;


        try {
            in = service.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<CustomerVO> list
                = gson.fromJson(new InputStreamReader(in), new TypeToken< List<CustomerVO> >(){}.getType());

        return  list;
    }

}

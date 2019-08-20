package com.shinhoandroid.aninterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FunctionManager.getInstance().addFunction(new FunctionNoParamNoResult("functionA") {
            @Override
            public void function() {
               e("我是没有参数没有回调的方法");
            }
        });

        FunctionManager.getInstance().addFunction(new FunctionNoParamHasResult<String>("functionB") {
            @Override
            public String function() {
                e("我是没有参数有回调的方法");
                return "lpf";
            }
        });


        FunctionManager.getInstance().invokeFunction("functionA");

        String functionB = FunctionManager.getInstance().invokeFunction("functionB", String.class);

        e(functionB);

    }

    public void e(String string){

        Log.e("lpf--",string);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        FunctionManager.getInstance().deleteFunction("functionA");
        FunctionManager.getInstance().deleteFunction("functionB");
    }
}

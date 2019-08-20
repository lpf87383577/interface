package com.shinhoandroid.aninterface;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/8/20 16:14
 */
public class FunctionManager {

    private static FunctionManager instance;

    private Map<String,FunctionNoParamNoResult> mNoParamNoResultMap;
    private Map<String,FunctionNoParamHasResult> mNoParamHasResultMap;
    private Map<String,FunctionHasParamNoResult> mNasParamNoResultMap;
    private Map<String,FunctionHasParamHasResult> mHasParamHasResultMap;

    private FunctionManager(){
        mNoParamNoResultMap = new HashMap<>();
        mNoParamHasResultMap = new HashMap<>();
        mNasParamNoResultMap = new HashMap<>();
        mHasParamHasResultMap = new HashMap<>();
    }

    public static FunctionManager getInstance(){
        if(instance == null){
            instance = new FunctionManager();
        }
        return instance;
    }

    //将四种类型的方法添加到FunctionManager;

    /** 添加没有参数，有返回值的方法 */
    public void addFunction(FunctionNoParamHasResult function){
        mNoParamHasResultMap.put(function.functionName,function);
    }

    /** 添加没有参数，没有返回值的方法*/
    public void addFunction(FunctionNoParamNoResult function){
        mNoParamNoResultMap.put(function.functionName,function);
    }

    /** 添加有参数，没有返回值的方法*/
    public void addFunction(FunctionHasParamNoResult function){
        mNasParamNoResultMap.put(function.functionName,function);
    }

    /** 添加有参数，有返回值的方法*/
    public void addFunction(FunctionHasParamHasResult function){
        mHasParamHasResultMap.put(function.functionName,function);
    }

    //执行没有参数，没有返回值的方法
    public void invokeFunction(String functionName){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mNoParamNoResultMap != null){
            FunctionNoParamNoResult f = mNoParamNoResultMap.get(functionName);
            if(f != null){
                f.function();
            }else{
                try {
                    throw new FunctionNotFoundException("方法不存在");
                } catch (FunctionNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //执行没有参数，有返回值的方法
    public <T> T  invokeFunction(String functionname,Class<T> t){
        if(TextUtils.isEmpty(functionname)){
            return null;
        }

        if(mNoParamNoResultMap != null){
            FunctionNoParamHasResult f = mNoParamHasResultMap.get(functionname);
            if(f!=null){
                //cast就是转换
                return t.cast(f.function());
            }else{
                try {
                    throw new FunctionNotFoundException("方法不存在！");
                } catch (FunctionNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //执行有参数，没有返回值的方法
    public <P> void invokeFunction(String functionName,P p){
        if(TextUtils.isEmpty(functionName)){
            return;
        }
        if(mNasParamNoResultMap != null){
            FunctionHasParamNoResult f = mNasParamNoResultMap.get(functionName);
            if(f != null){
                f.function(p);
            }else{
                try {
                    throw new FunctionNotFoundException("方法不存在");
                } catch (FunctionNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //执行有参数，有返回值的方法
    public <T,P> T invokeFunction(String functionName,P p ,Class<T> t){
        if(TextUtils.isEmpty(functionName)){
            return null;
        }
        if(mHasParamHasResultMap != null){
            FunctionHasParamHasResult f = mHasParamHasResultMap.get(functionName);
            if(f != null){
                return t.cast(f.function(p));
            }else{
                try {
                    throw new FunctionNotFoundException("方法不存在");
                } catch (FunctionNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    public void deleteFunction(String functionName){

        if(TextUtils.isEmpty(functionName)){
            return ;
        }
        if (mNoParamNoResultMap!=null){

            mNoParamNoResultMap.remove(functionName);
        }
        if (mNoParamHasResultMap!=null){

            mNoParamHasResultMap.remove(functionName);
        }
        if (mNasParamNoResultMap!=null){

            mNasParamNoResultMap.remove(functionName);
        }
        if (mHasParamHasResultMap!=null){

            mHasParamHasResultMap.remove(functionName);
        }

    }
}

package com.shinhoandroid.aninterface;

/**
 * @author Liupengfei
 * @describe 没有参数有返回值
 * @date on 2019/8/20 16:11
 */
public abstract class FunctionNoParamHasResult<T> extends Function{

    public FunctionNoParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function();
}

package com.shinhoandroid.aninterface;

/**
 * @author Liupengfei
 * @describe 有参数没有返回值
 * @date on 2019/8/20 16:12
 */
public abstract class FunctionHasParamNoResult<P> extends Function {

    public FunctionHasParamNoResult(String functionName) {
        super(functionName);
    }

    public abstract void  function(P p);

}

package com.shinhoandroid.aninterface;

/**
 * @author Liupengfei
 * @describe TODO
 * @date on 2019/8/20 16:13
 */
public abstract class FunctionHasParamHasResult<T,P> extends Function{

    public FunctionHasParamHasResult(String functionName) {
        super(functionName);
    }

    public abstract T function(P p);


}

package com.linchen.common;

import java.io.Serializable;

/**
 * @Author 林晨
 * @Date 2023-08-06 11:19
 * @PackageName:com.linchen.common
 * @ClassName: Invocation
 * @Description: TODO
 * @Version 1.0
 */
public class Invocation implements Serializable {
    private String InterfaceName;
    private String methodName;
    //方法类型参数
    private Class[] parameterTypes;
    //方法参数
    private Object[] parameters;

    public Invocation(String interfaceName, String methodName, Class[] parameterTypes, Object[] parameters) {
        InterfaceName = interfaceName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public Invocation() {
    }

    public String getInterfaceName() {
        return InterfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}

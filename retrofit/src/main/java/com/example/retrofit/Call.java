package com.example.retrofit;

public class Call<V> {

    private String methodAnntion;
    private String  paramterAnntion;
    private String  paramter;
    private String  methodName;
    public Call(ServiceMethod serviceMethod) {
        methodName = serviceMethod.getMethodName();
        methodAnntion = serviceMethod.getMethodAnntion();
        paramterAnntion = serviceMethod.getParamterAnntion();
    }

    public String getMethodAnntion() {
        return methodAnntion;
    }

    public void setMethodAnntion(String methodAnntion) {
        this.methodAnntion = methodAnntion;
    }

    public String getParamterAnntion() {
        return paramterAnntion;
    }

    public void setParamterAnntion(String paramterAnntion) {
        this.paramterAnntion = paramterAnntion;
    }

    public String getParamter() {
        return paramter;
    }

    public void setParamter(String paramter) {
        this.paramter = paramter;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

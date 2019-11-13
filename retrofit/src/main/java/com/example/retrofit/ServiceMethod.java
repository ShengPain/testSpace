package com.example.retrofit;

import java.lang.reflect.Method;

public class ServiceMethod <R,V> {
    CallAdapter<R,V> callAdapter;
    private String methodName;
    private String methodAnntion;
    private String paramterAnntion;

    public ServiceMethod(CallAdapter<R, V> callAdapter, String methodName, String methodAnntion, String paramterAnntion) {
        this.callAdapter = callAdapter;
        this.methodName = methodName;
        this.methodAnntion = methodAnntion;
        this.paramterAnntion = paramterAnntion;
    }

    public CallAdapter<R, V> getCallAdapter() {
        return callAdapter;
    }

    public void setCallAdapte(CallAdapter<R, V> callAdapter) {
        this.callAdapter = callAdapter;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
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

    public static class Build  <R,V>{
        RetroFit retroFit;
        CallAdapter<R,V> callAdapter;
        private String methodName;
        private String methodAnntion;
        private String  paramterAnntion;
        private String  paramter;

        public Build(Method method,RetroFit  retroFit) {
            this.callAdapter = retroFit.callAdapter(method.getReturnType());
            String s ="";
            for (int i = 0; i < method.getAnnotations().length; i++) {
                s+= method.getAnnotations()[i].toString();
            }

            this.methodAnntion = s;
            this.methodName = method.getName();
            s = "";
            for (int i = 0; i < method.getParameterAnnotations().length; i++) {
                for (int j = 0; j < method.getParameterAnnotations()[i].length; j++) {
                    s +=method.getParameterAnnotations()[i][j].toString();
                }

            }
            this.paramterAnntion = s;

        }


        public ServiceMethod build(){
            return  new ServiceMethod(callAdapter,methodName,methodAnntion,paramterAnntion);
        }


    }
}

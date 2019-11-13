package com.example.retrofit;

public class TestCall {

    private String methodAnntion;
    private String  paramterAnntion;
    private String  paramter;
    private String  methodName;
    public TestCall(Call call,Object[] object) {
        this.methodName = call.getMethodName();
        this.methodAnntion = call.getMethodAnntion();
        this.paramterAnntion = call.getParamterAnntion();
        String s  ="";
        for(Object o : object){
            s+=o;
        }
        this.paramter = s;
    }

    @Override
    public String toString() {
        return "TestCall{" +
                "methodAnntion='" + methodAnntion + '\'' +
                ", paramterAnntion='" + paramterAnntion + '\'' +
                ", paramter='" + paramter + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}

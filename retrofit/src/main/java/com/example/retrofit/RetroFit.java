package com.example.retrofit;

import android.webkit.JavascriptInterface;

import com.example.retrofit.anntation.Test;
import com.example.retrofit.anntation.TestMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;

public class RetroFit <E extends Number> {



 /*  public static <T>T  create(Class<?> clazz){
       Object o = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
           @Override
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               ServiceMethod<?, ?> build = ServiceMethod.build(method);
               MyCall<String> stringMyCall = new MyCall<>();
//               Object adapt = build.adapter.adapt(stringMyCall);
               return null;

           }
       });
       return (T) o;


   }*/


 public CallAdapter<?,?> callAdapter(Type type){
     return CallAdapterFactory.INSTANCE.get(type,null);
 }


  public  <T>T create(Class<T> clazz){
     return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              ServiceMethod<Object,Object> serviceMethod = null;
               serviceMethod = new ServiceMethod.Build<>(method,RetroFit.this).build();
              Call<Object> objectCall = new Call<>(serviceMethod);
              return serviceMethod.callAdapter.adapt(objectCall,args);
          }
      });
  }




    public static void main1(String[] args) throws NoSuchMethodException {
        Method m =  RetroFit.class.getMethod("testMain",new Class[]{Map.class,String.class});
        Annotation[] annotations = m.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println("method == "+annotations[i].toString());
        }

        Annotation[][] parameterAnnotations = m.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                System.out.println("paramter1 == "+parameterAnnotations[i][j].toString());
            }
            Class<?> returnType = m.getReturnType();
            Type genericReturnType = m.getGenericReturnType();
            Class<?>[] parameterTypes = m.getParameterTypes();

            System.out.println("===========");
        } Class<?> returnType = m.getReturnType();
        Type genericReturnType = m.getGenericReturnType();
        Type[] parameterTypes = m.getGenericParameterTypes();
        System.out.println("returnType == "+returnType);
        System.out.println("genericReturnType == "+genericReturnType);
        for (int i = 0; i < parameterTypes.length; i++) {
            System.out.println(parameterTypes[i]);
        }

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
         m =  RetroFit.class.getMethod("test");
        Type genericReturnType1 = m.getGenericReturnType();
        System.out.println(genericReturnType1);
        System.out.println("TypeVariable  == "+(genericReturnType1 instanceof TypeVariable) );
        System.out.println("WildcardType  == "+(genericReturnType1 instanceof WildcardType) );
        System.out.println("ParameterizedType  == "+(genericReturnType1 instanceof ParameterizedType) );
        System.out.println("Class  == "+(genericReturnType1 instanceof Class) );
        Type[] genericSuperclass = RetroFit.class.getTypeParameters();
        TypeVariable typeVariable = (TypeVariable) genericSuperclass[0];
        Type[] bounds = typeVariable.getBounds();
        System.out.println(bounds[0].toString());
        System.out.println(genericSuperclass[0].toString()+ (genericSuperclass[0] instanceof WildcardType));
    }


    public static void main(String[] args) {
        RetroFit<Number> numberRetroFit = new RetroFit<>();
        TestApi testApi = numberRetroFit.create(TestApi.class);
        TestCall call = testApi.getAnnntion("sfdsfdasf", "111111");
        System.out.println(call.toString());
    }

    @TestMethod(str ="string")
    public ArrayList<String> testMain(@Test("paramter1") Map<String,String> value , @Test String value2){
        return  null;
    }


    public <T extends String> T test(){
       return null;
    }











}

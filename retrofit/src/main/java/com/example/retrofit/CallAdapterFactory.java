package com.example.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public interface CallAdapterFactory   {

    CallAdapter<?,?> get(Type returnType, RetroFit retroFit);

    CallAdapterFactory INSTANCE = new CallAdapterFactory() {
        @Override
        public CallAdapter<TestCall, ?> get(Type returnType, RetroFit retroFit) {

            return new CallAdapter<TestCall, Object>() {
                @Override
                public TestCall adapt(Call<Object> objectCall,Object[] objects) {
                    return new TestCall(objectCall,objects);
                }
            };
        }
    };
}

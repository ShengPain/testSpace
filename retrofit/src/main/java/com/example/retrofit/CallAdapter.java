package com.example.retrofit;

public interface CallAdapter <R,V> {

    R adapt(Call<V> vCall,Object[] objects);
}

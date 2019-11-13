package com.example.retrofit;

import com.example.retrofit.anntation.Test;
import com.example.retrofit.anntation.TestMethod;

public interface TestApi {

   @TestMethod
   public TestCall getAnnntion(@Test String str,@Test String str1);


}

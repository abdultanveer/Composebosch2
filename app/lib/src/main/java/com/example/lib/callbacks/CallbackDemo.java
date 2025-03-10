package com.example.lib.callbacks;


public class CallbackDemo {

    int rekhaAdd(int a, int b){
        return a+b;
    }

    //radio h/w data internet--raise interrupt
    void muraliAdd(int a, int b,MyPhNumber callbackPhno){
        try {
            Thread.sleep(5000);//unsure --suspended
            callbackPhno.onSuccess(a+b);  //resumed
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

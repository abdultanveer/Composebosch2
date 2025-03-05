package com.example.lib.callbacks;


public class CallbackDemo {

    int rekhaAdd(int a, int b){
        return a+b;
    }

    //radio h/w data internet--raise interrupt
    void muraliAdd(int a, int b,MyPhNumber callbackPhno){
        try {
            Thread.sleep(5000);
            callbackPhno.onSuccess(a+b);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

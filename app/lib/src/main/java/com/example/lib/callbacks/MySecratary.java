package com.example.lib.callbacks;


public class MySecratary implements MyPhNumber{
    @Override
    public void onSuccess(int result) {
        System.out.println("i received the call and the result is --"+result);
    }
}

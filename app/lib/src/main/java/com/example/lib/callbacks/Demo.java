package com.example.lib.callbacks;

public class Demo {

    //go for a callback when you don't knonw how much time it will take to complete the task
    //getting data from internet/db --- show the fetched data on the ui
    public static void main(String[] args) {
        CallbackDemo callbackDemo = new CallbackDemo();
       int rresult = callbackDemo.rekhaAdd(10,20);
        System.out.println("rekha returned the result --"+rresult);

        MyPhNumber myPhNumber = new MySecratary();

        callbackDemo.muraliAdd(10,20,myPhNumber);
    }
}

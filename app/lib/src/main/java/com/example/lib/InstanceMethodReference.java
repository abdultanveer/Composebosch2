package com.example.lib;

import com.example.lib.interfaces.GEAppliances;
import com.example.lib.interfaces.HavellsAc;
import com.example.lib.interfaces.SwitchBoardListener;

interface Sayable{
    void say();
}
public class InstanceMethodReference {
    public void saySomething(){
        System.out.println("Hello, this is non-static method.");
    }
    public static void main(String[] args) {
        SwitchBoardListener sbl = new HavellsAc();
                //new GEAppliances();  //connection --wiring
        sbl.switchOne();  //user clicking the switch
    }
}
package com.example.lib.interfaces;


public class HavellsAc implements SwitchBoardListener{


    @Override
    public void switchOne() {
        System.out.println("AC is on-- room is cool");
    }
}

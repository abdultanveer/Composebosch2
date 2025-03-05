package com.example.lib.interfaces;

public class GEAppliances implements SwitchBoardListener {
    @Override
    public void switchOne() {

        System.out.println("the fan is on--room is cool");
    }
}

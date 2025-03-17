// IMyAidlInterface.aidl
package com.example.composebosch;

//rebuild the app -- it'll invoke aidl tool, which will gennerate a stub class
interface IMyAidlInterface {

    int add(int a, int b);
    int getTyrePressure();
}

//steps
//A -- enabled aidl in app build,.gradle
//B. -- right clicked on the package --new-aidl--created the file
//c. i created the methods in the aidl file
//d. implemented the aidlbinder in the service
//e. in manifest add intent filter with the action string
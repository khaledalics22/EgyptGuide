package com.example.egyptguide;

import java.io.Serializable;

public class BankClass extends Entity implements Serializable {
    public BankClass(String mName, String mDescription, String mLocation, int[] mImageResources, String workTime, String phone) {
        super(mName, mDescription, mLocation, mImageResources, workTime, phone);
    }
}

package com.example.egyptguide;

import java.io.Serializable;

public class EntertainmentClass extends Entity implements Serializable {
    public EntertainmentClass(String mName, String mDescription, String mLocation, int[] mImageResources, String workTime, String phone) {
        super(mName, mDescription, mLocation, mImageResources, workTime, phone);
    }
}

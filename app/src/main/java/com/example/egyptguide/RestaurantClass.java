package com.example.egyptguide;

import java.io.Serializable;

public class RestaurantClass extends Entity implements Serializable {
    public RestaurantClass(String mName, String mDescription, String mLocation, int[] mImageResources, String workTime, String phoneNo) {
        super(mName, mDescription, mLocation, mImageResources, workTime, phoneNo);
    }
}

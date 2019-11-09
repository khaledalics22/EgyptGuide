package com.example.egyptguide;

import java.io.Serializable;

public class HotelClass extends Entity implements Serializable {
    private int mPricePerDay = 0;

    public HotelClass(String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources, String workTime, String phone) {
        super(mName, mDescription, mLocation, mImageResources, workTime, phone);
        this.mPricePerDay = mPricePerDay;
    }

    public void setmPricePerDay(int mPricePerDay) {
        this.mPricePerDay = mPricePerDay;
    }

    public int getmPricePerDay() {
        return mPricePerDay;
    }


}

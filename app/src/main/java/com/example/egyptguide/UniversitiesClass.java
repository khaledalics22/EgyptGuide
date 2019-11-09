package com.example.egyptguide;

import java.io.Serializable;

public class UniversitiesClass extends Entity implements Serializable {
    private int mFees;

    public UniversitiesClass(String mName, String mDescription, int fees, String mLocation, int[] mImageResources, String workTime, String phone) {
        super(mName, mDescription, mLocation, mImageResources, workTime, phone);
        this.mFees = fees;
    }

    public void setmFees(int mPricePerDay) {
        this.mFees = mPricePerDay;
    }

    public int getmFees() {
        return mFees;
    }
}

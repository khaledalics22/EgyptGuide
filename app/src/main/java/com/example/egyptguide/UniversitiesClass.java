package com.example.egyptguide;

public class UniversitiesClass {
    private String mName;
    private String mDescription;
    private int mFees;
    private String mLocation;
    private int [] mImageResources;

    public UniversitiesClass(String mName, String mDescription, int mPricePerDay, String mLocation, int[] mImageResources) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mFees = mPricePerDay;
        this.mLocation = mLocation;
        this.mImageResources = mImageResources;
    }

    public void setmDescription(String mDescription) {

        this.mDescription = mDescription;
    }

    public void setmPricePerDay(int mPricePerDay) {
        this.mFees = mPricePerDay;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public void setmImageResources(int[] mImageResources) {
        this.mImageResources = mImageResources;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmName() {
        return mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmPricePerDay() {
        return mFees;
    }

    public String getmLocation() {
        return mLocation;
    }

    public int[] getmImageResources() {
        return mImageResources;
    }
}

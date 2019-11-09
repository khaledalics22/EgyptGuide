package com.example.egyptguide;

public class BankClass {
    private String mName;
    private String mDescription;
    private String mLocation;
    private int [] mImageResources;

    public BankClass(String mName, String mDescription, String mLocation, int[] mImageResources) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mLocation = mLocation;
        this.mImageResources = mImageResources;
    }

    public void setmDescription(String mDescription) {

        this.mDescription = mDescription;
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


    public String getmLocation() {
        return mLocation;
    }

    public int[] getmImageResources() {
        return mImageResources;
    }
}

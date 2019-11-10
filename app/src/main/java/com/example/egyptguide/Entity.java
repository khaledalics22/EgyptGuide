package com.example.egyptguide;

import java.io.Serializable;

public class Entity implements Serializable {
    private String mName;
    private String mDescription;
    private String mLocation;
    private int[] mImageResources;
    private String mWorkTime;
    private boolean mIsPreferred = false;
    private String phoneNumber;

    public Entity(String mName, String mDescription, String mLocation, int[] mImageResources, String mWorkTime, String phoneNumber) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mLocation = mLocation;
        this.mImageResources = mImageResources;
        this.mWorkTime = mWorkTime;
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setmWorkTime(String mWorkTime) {
        this.mWorkTime = mWorkTime;
    }

    public String getmWorkTime() {
        return mWorkTime;
    }

    public boolean ismIsPreferred() {
        return mIsPreferred;
    }

    public void setmIsPreferred(boolean mIsPreferred) {
        this.mIsPreferred = mIsPreferred;
    }

    public Entity(String mName, String mDescription, String mLocation, int[] mImageResources, String mWorkTime) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mLocation = mLocation;
        this.mImageResources = mImageResources;
        this.mWorkTime = mWorkTime;
    }

    public Entity(String mName, String mDescription, String mLocation, int[] mImageResources) {
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

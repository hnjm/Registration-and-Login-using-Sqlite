package com.example.android.quakereport;

public class EarthQuake {
    private Double mMagnitude;
    private String mPlaceName;
    private Long mTime;
    private String mUrl;

    public EarthQuake(Double mMagnitude, String mPlaceName, Long mTime, String mUrl) {
        this.mMagnitude = mMagnitude;
        this.mPlaceName = mPlaceName;
        this.mTime = mTime;
        this.mUrl = mUrl;

    }

    public  Double getmMagnitude() {
        return mMagnitude;
    }

    public String getmPlaceName() {
        return mPlaceName;
    }

    public Long getmTime() {
        return mTime;
    }

    public String getmUrl() {
        return mUrl;
    }
}

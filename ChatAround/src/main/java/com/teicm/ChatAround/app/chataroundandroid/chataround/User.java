package com.teicm.ChatAround.app.chataroundandroid.chataround;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.activeandroid.annotation.Column;


@Table(name = "USER")
public class User extends Model{
    @Column(name = "user_name")
    private String userName;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    public User() { super(); }

    public User(String userName, Double latitude, Double longitude) {
        super();

        this.userName = userName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}

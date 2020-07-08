package com.example.splashscreenwithlogin;

public class Member {

    private String Name;
    private String cmpName;
    private String City;
    private Number mbNumber;

    public Member() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Number getMbNumber() {
        return mbNumber;
    }

    public void setMbNumber(Number mbNumber) {
        this.mbNumber = mbNumber;
    }
}


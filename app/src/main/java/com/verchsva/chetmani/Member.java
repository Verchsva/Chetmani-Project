package com.verchsva.chetmani;

public class Member {

    private String Name;
    private String cmpName;
    private String City;
    private String mbNumber;

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

    public String getMbNumber() {
        return mbNumber;
    }

    public void setMbNumber(String mbNumber) {
        this.mbNumber = mbNumber;
    }
}


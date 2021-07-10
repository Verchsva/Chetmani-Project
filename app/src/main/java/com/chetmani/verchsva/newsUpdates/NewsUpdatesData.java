package com.chetmani.verchsva.newsUpdates;

public class NewsUpdatesData {

    String heading,description,time;

    public NewsUpdatesData() {
    }

    @Override
    public String toString() {
        return "NewsUpdatesData{" +
                "heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

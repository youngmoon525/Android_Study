package com.hanul.busapp.bus;

public class BusVO {
    String station, route;

    public BusVO(String station) {
        this.station = station;
    }

    public BusVO(String station, String route) {
        this.station = station;
        this.route = route;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}

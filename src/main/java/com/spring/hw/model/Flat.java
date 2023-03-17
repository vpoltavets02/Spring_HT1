package com.spring.hw.model;

public class Flat {
    private int id;
    private String region;
    private String address;
    private int area;
    private int noRooms;
    private int price;

    public Flat() {
    }

    public Flat(String region, int area, int noRooms, int price) {
        this.region = region;
        this.area = area;
        this.noRooms = noRooms;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(int noRooms) {
        this.noRooms = noRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "region='" + region + '\'' +
                ", area=" + area +
                ", noRooms=" + noRooms +
                ", price=" + price +
                '}';
    }
}

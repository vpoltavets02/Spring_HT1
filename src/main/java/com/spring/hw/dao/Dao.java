package com.spring.hw.dao;

import java.util.List;

public interface Dao<T> {
    List<T> flatList(String region, int area, int noRooms, int price);
}

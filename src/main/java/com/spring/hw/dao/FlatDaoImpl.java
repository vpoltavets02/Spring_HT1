package com.spring.hw.dao;

import com.spring.hw.db_connector.Connector;
import com.spring.hw.model.Flat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FlatDaoImpl implements Dao<Flat> {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private final List<Flat> flatList;

    public FlatDaoImpl() {
        flatList = new CopyOnWriteArrayList<>();
    }

    private Connection getConnection() throws SQLException {
        return Connector.getInstance().getConnection();
    }

    private void resourceCLoser() throws SQLException {
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }

    @Override
    public List<Flat> flatList(String region, int area, int noRooms, int price) {
        try {
            String query = "SELECT * FROM flats WHERE region=? AND area<=? " +
                    "AND rooms_amount<=? AND price<=?;";
            connection = getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, region);
            statement.setInt(2, area);
            statement.setInt(3, noRooms);
            statement.setInt(4, price);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flat flat = new Flat();
                flat.setId(resultSet.getInt("flat_id"));
                flat.setRegion(resultSet.getString("region"));
                flat.setAddress(resultSet.getString("address"));
                flat.setArea(resultSet.getInt("area"));
                flat.setNoRooms(resultSet.getInt("rooms_amount"));
                flat.setPrice(resultSet.getInt("price"));
                flatList.add(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resourceCLoser();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flatList;
    }
}
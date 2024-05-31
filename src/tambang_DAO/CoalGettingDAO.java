/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambang_DAO;

/**
 *
 * @author User
 */
import CRUD.DatabaseConnection;
import asai_project_model.CoalGetting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoalGettingDAO {

    public void create(CoalGetting coalGetting) throws SQLException {
        String sql = "INSERT INTO coal_getting (id, date, material, qty, type, pit) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, coalGetting.getId());
            stmt.setDate(2, new java.sql.Date(coalGetting.getDate().getTime()));
            stmt.setString(3, coalGetting.getMaterial());
            stmt.setDouble(4, coalGetting.getQty());
            stmt.setString(5, coalGetting.getType());
            stmt.setString(6, coalGetting.getPit());
            stmt.executeUpdate();
        }
    }

    public CoalGetting read(int id) throws SQLException {
        String sql = "SELECT * FROM coal_getting WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new CoalGetting(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("material"),
                        rs.getDouble("qty"),
                        rs.getString("type"),
                        rs.getString("pit")
                );
            }
        }
        return null;
    }

    public List<CoalGetting> readAll() throws SQLException {
        List<CoalGetting> coalGettings = new ArrayList<>();
        String sql = "SELECT * FROM coal_getting";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                coalGettings.add(new CoalGetting(
                        rs.getInt("id"),
                        rs.getDate("date"),
                        rs.getString("material"),
                        rs.getDouble("qty"),
                        rs.getString("type"),
                        rs.getString("pit")
                ));
            }
        }
        return coalGettings;
    }

    public void update(CoalGetting coalGetting) throws SQLException {
        String sql = "UPDATE coal_getting SET date = ?, material = ?, qty = ?, type = ?, pit = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(coalGetting.getDate().getTime()));
            stmt.setString(2, coalGetting.getMaterial());
            stmt.setDouble(3, coalGetting.getQty());
            stmt.setString(4, coalGetting.getType());
            stmt.setString(5, coalGetting.getPit());
            stmt.setInt(6, coalGetting.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM coal_getting WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

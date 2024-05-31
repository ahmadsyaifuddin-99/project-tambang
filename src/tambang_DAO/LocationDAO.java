/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambang_DAO;

/**
 *
 * @author User
 */
import asai.project.model.Location;
import CRUD.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO {

    public void create(Location location) throws SQLException {
        String sql = "INSERT INTO location (code_location, desc_location, created_at) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, location.getCodeLocation());
            stmt.setString(2, location.getDescLocation());
            stmt.setDate(3, new java.sql.Date(location.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }

    public Location read(String codeLocation) throws SQLException {
        String sql = "SELECT * FROM location WHERE code_location = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codeLocation);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Location(
                        rs.getString("code_location"),
                        rs.getString("desc_location"),
                        rs.getDate("created_at")
                );
            }
        }
        return null;
    }

    public List<Location> readAll() throws SQLException {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT * FROM location";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                locations.add(new Location(
                        rs.getString("code_location"),
                        rs.getString("desc_location"),
                        rs.getDate("created_at")
                ));
            }
        }
        return locations;
    }

    public void update(Location location) throws SQLException {
        String sql = "UPDATE location SET desc_location = ?, created_at = ? WHERE code_location = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, location.getDescLocation());
            stmt.setDate(2, new java.sql.Date(location.getCreatedAt().getTime()));
            stmt.setString(3, location.getCodeLocation());
            stmt.executeUpdate();
        }
    }

    public void delete(String codeLocation) throws SQLException {
        String sql = "DELETE FROM location WHERE code_location = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codeLocation);
            stmt.executeUpdate();
        }
    }
}

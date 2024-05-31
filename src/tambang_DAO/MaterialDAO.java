package tambang_DAO;

import asai_project_model.Material;
import Koneksi.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void create(Material material) throws SQLException {
        String sql = "INSERT INTO material (code_material, desc_material, comp_material, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getCodeMaterial());
            stmt.setString(2, material.getDescMaterial());
            stmt.setString(3, material.getCompMaterial());
            stmt.setDate(4, new java.sql.Date(material.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }

    public Material read(String codeMaterial) throws SQLException {
        String sql = "SELECT * FROM material WHERE code_material = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codeMaterial);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Material(
                        rs.getString("code_material"),
                        rs.getString("desc_material"),
                        rs.getString("comp_material"),
                        rs.getDate("created_at")
                );
            }
        }
        return null;
    }

    public List<Material> readAll() throws SQLException {
        List<Material> materials = new ArrayList<>();
        String sql = "SELECT * FROM material";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                materials.add(new Material(
                        rs.getString("code_material"),
                        rs.getString("desc_material"),
                        rs.getString("comp_material"),
                        rs.getDate("created_at")
                ));
            }
        }
        return materials;
    }

    public void update(Material material) throws SQLException {
        String sql = "UPDATE material SET desc_material = ?, comp_material = ?, created_at = ? WHERE code_material = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getDescMaterial());
            stmt.setString(2, material.getCompMaterial());
            stmt.setDate(3, new java.sql.Date(material.getCreatedAt().getTime()));
            stmt.setString(4, material.getCodeMaterial());
            stmt.executeUpdate();
        }
    }

    public void delete(String codeMaterial) throws SQLException {
        String sql = "DELETE FROM material WHERE code_material = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codeMaterial);
            stmt.executeUpdate();
        }
    }
}

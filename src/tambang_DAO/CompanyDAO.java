/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tambang_DAO;

/**
 *
 * @author User
 */
import asai_project_model.Company;
import CRUD.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    public void create(Company company) throws SQLException {
        String sql = "INSERT INTO company (id, code_company, desc_company, created_at) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, company.getId());
            stmt.setString(2, company.getCodeCompany());
            stmt.setString(3, company.getDescCompany());
            stmt.setDate(4, new java.sql.Date(company.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }

    public Company read(int id) throws SQLException {
        String sql = "SELECT * FROM company WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Company(
                        rs.getInt("id"),
                        rs.getString("code_company"),
                        rs.getString("desc_company"),
                        rs.getDate("created_at")
                );
            }
        }
        return null;
    }

    public List<Company> readAll() throws SQLException {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM company";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                companies.add(new Company(
                        rs.getInt("id"),
                        rs.getString("code_company"),
                        rs.getString("desc_company"),
                        rs.getDate("created_at")
                ));
            }
        }
        return companies;
    }

    public void update(Company company) throws SQLException {
        String sql = "UPDATE company SET code_company = ?, desc_company = ?, created_at = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, company.getCodeCompany());
            stmt.setString(2, company.getDescCompany());
            stmt.setDate(3, new java.sql.Date(company.getCreatedAt().getTime()));
            stmt.setInt(4, company.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM company WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

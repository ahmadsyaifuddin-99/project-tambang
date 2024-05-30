package project.tambang;

import asai.project.model.CoalGetting;
import asai.project.model.Company;
import asai.project.model.Location;
import asai.project.model.Material;
import CRUD.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Input untuk CoalGetting
            System.out.println("Masukkan ID:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer
            
            System.out.println("Masukkan tanggal (format: yyyy-mm-dd):");
            String dateInput = scanner.nextLine();
            Date date = java.sql.Date.valueOf(dateInput);
            
            System.out.println("Masukkan material:");
            String material = scanner.nextLine();
            
            System.out.println("Masukkan kuantitas:");
            double qty = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer
            
            System.out.println("Masukkan tipe:");
            String type = scanner.nextLine();
            
            System.out.println("Masukkan pit:");
            String pit = scanner.nextLine();
            
            // Membuat objek CoalGetting dengan data yang diinputkan
            CoalGetting coalGetting = new CoalGetting(id, date, material, qty, type, pit);
            System.out.println(coalGetting);

            // Input untuk Location
            System.out.println("Masukkan kode lokasi:");
            String codeLocation = scanner.nextLine();
            
            System.out.println("Masukkan deskripsi lokasi:");
            String descLocation = scanner.nextLine();
            
            System.out.println("Masukkan tanggal pembuatan (format: yyyy-mm-dd):");
            String createdAtInput = scanner.nextLine();
            Date createdAt = java.sql.Date.valueOf(createdAtInput);
            
            // Membuat objek Location dengan data yang diinputkan
            Location location = new Location(codeLocation, descLocation, createdAt);
            System.out.println(location);
            
            // Input untuk Company
            System.out.println("Masukkan ID perusahaan:");
            int companyId = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer
            
            System.out.println("Masukkan kode perusahaan:");
            String codeCompany = scanner.nextLine();
            
            System.out.println("Masukkan deskripsi perusahaan:");
            String descCompany = scanner.nextLine();
            
            System.out.println("Masukkan tanggal pembuatan perusahaan (format: yyyy-mm-dd):");
            String companyCreatedAtInput = scanner.nextLine();
            Date companyCreatedAt = java.sql.Date.valueOf(companyCreatedAtInput);
            
            // Membuat objek Company dengan data yang diinputkan
            Company company = new Company(companyId, codeCompany, descCompany, companyCreatedAt);
            System.out.println(company);
            
            // Input untuk Material
            System.out.println("Masukkan kode material:");
            String codeMaterial = scanner.nextLine();
            
            System.out.println("Masukkan deskripsi material:");
            String descMaterial = scanner.nextLine();
            
            System.out.println("Masukkan perusahaan material:");
            String compMaterial = scanner.nextLine();
            
            System.out.println("Masukkan tanggal pembuatan material (format: yyyy-mm-dd):");
            String materialCreatedAtInput = scanner.nextLine();
            Date materialCreatedAt = java.sql.Date.valueOf(materialCreatedAtInput);
            
            // Membuat objek Material dengan data yang diinputkan
            Material materialObj = new Material(codeMaterial, descMaterial, compMaterial, materialCreatedAt);
            System.out.println(materialObj);

            // Menyimpan data ke database
            try (Connection connection = DatabaseConnection.getConnection()) {
                saveCoalGetting(connection, coalGetting);
                saveLocation(connection, location);
                saveCompany(connection, company);
                saveMaterial(connection, materialObj);
            } catch (SQLException e) {
            }
        }
    }

    private static void saveCoalGetting(Connection connection, CoalGetting coalGetting) throws SQLException {
        String sql = "INSERT INTO coal_getting (id, date, material, qty, type, pit) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, coalGetting.getId());
            stmt.setDate(2, new java.sql.Date(coalGetting.getDate().getTime()));
            stmt.setString(3, coalGetting.getMaterial());
            stmt.setDouble(4, coalGetting.getQty());
            stmt.setString(5, coalGetting.getType());
            stmt.setString(6, coalGetting.getPit());
            stmt.executeUpdate();
        }
    }

    private static void saveLocation(Connection connection, Location location) throws SQLException {
        String sql = "INSERT INTO location (code_location, desc_location, created_at) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, location.getCodeLocation());
            stmt.setString(2, location.getDescLocation());
            stmt.setDate(3, new java.sql.Date(location.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }

    private static void saveCompany(Connection connection, Company company) throws SQLException {
        String sql = "INSERT INTO company (id, code_company, desc_company, created_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, company.getId());
            stmt.setString(2, company.getCodeCompany());
            stmt.setString(3, company.getDescCompany());
            stmt.setDate(4, new java.sql.Date(company.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }

    private static void saveMaterial(Connection connection, Material material) throws SQLException {
        String sql = "INSERT INTO material (code_material, desc_material, comp_material, created_at) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getCodeMaterial());
            stmt.setString(2, material.getDescMaterial());
            stmt.setString(3, material.getCompMaterial());
            stmt.setDate(4, new java.sql.Date(material.getCreatedAt().getTime()));
            stmt.executeUpdate();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/2210010111_tambang";
    private static final String USER = "root"; // Ganti dengan user MySQL Anda
    private static final String PASSWORD = ""; // Ganti dengan password MySQL Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Koneksi ke database berhasil!");

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Koneksi ke database gagal: " + e.getMessage());
        }
    }
}

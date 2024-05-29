/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.tambang;

/**
 *
 * @author User
 */

import asai.project.model.MaterialLocation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Input untuk Material
        try (Scanner scanner = new Scanner(System.in)) {
            // Input untuk Material
            System.out.println("Masukkan nama material:");
            String name = scanner.nextLine();
            
            System.out.println("Masukkan densitas material:");
            double density = scanner.nextDouble();
            scanner.nextLine();  // Clear the buffer
            
            // Input untuk Location
            System.out.println("Masukkan alamat lokasi:");
            String address = scanner.nextLine();
            
            System.out.println("Masukkan kota lokasi:");
            String city = scanner.nextLine();
            
            // Membuat objek MaterialLocation dengan data yang diinputkan
            MaterialLocation materialLocation = new MaterialLocation(name, density, address, city);
            System.out.println(materialLocation);
            
            // Mengubah alamat
            System.out.println("Masukkan alamat baru:");
            String newAddress = scanner.nextLine();
            materialLocation.setAddress(newAddress);
            System.out.println("Updated Address: " + materialLocation.getAddress());
            
            // Mengubah kota
            System.out.println("Masukkan kota baru:");
            String newCity = scanner.nextLine();
            materialLocation.setCity(newCity);
            System.out.println("Updated City: " + materialLocation.getCity());
        }
    }
}


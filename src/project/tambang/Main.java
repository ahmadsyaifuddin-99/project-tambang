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

public class Main {
    public static void main(String[] args) {
        MaterialLocation materialLocation = new MaterialLocation("Steel", 7.85, "123 Industrial Rd", "Metaltown");
        System.out.println(materialLocation);

        // Mengubah alamat
        materialLocation.setAddress("456 Manufacturing Ave");
        System.out.println("Updated Address: " + materialLocation.getAddress());

        // Mengubah kota
        materialLocation.setCity("New Metaltown");
        System.out.println("Updated City: " + materialLocation.getCity());
    }
}

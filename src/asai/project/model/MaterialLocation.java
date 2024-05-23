/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asai.project.model;

/**
 *
 * @author User
 */
public class MaterialLocation extends Material {
    private Location location;

    public MaterialLocation(String name, double density, String address, String city) {
        super(name, density);
        this.location = new Location(address, city);
    }

    public String getAddress() {
        return location.getAddress();
    }

    public void setAddress(String address) {
        location.setAddress(address);
    }

    public String getCity() {
        return location.getCity();
    }

    public void setCity(String city) {
        location.setCity(city);
    }

    @Override
    public String toString() {
        return "MaterialLocation{" +
                "name='" + getName() + '\'' +
                ", density=" + getDensity() +
                ", address='" + getAddress() + '\'' +
                ", city='" + getCity() + '\'' +
                '}';
    }
}
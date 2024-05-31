/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asai_project_model;

import java.util.Date;

public class CoalGetting {
    private int id;
    private Date date;
    private String material;
    private double qty;
    private String type;
    private String pit;

    public CoalGetting(int id, Date date, String material, double qty, String type, String pit) {
        this.id = id;
        this.date = date;
        this.material = material;
        this.qty = qty;
        this.type = type;
        this.pit = pit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPit() {
        return pit;
    }

    public void setPit(String pit) {
        this.pit = pit;
    }

    @Override
    public String toString() {
        return "CoalGetting{" +
                "id=" + id +
                ", date=" + date +
                ", material='" + material + '\'' +
                ", qty=" + qty +
                ", type='" + type + '\'' +
                ", pit='" + pit + '\'' +
                '}';
    }
}

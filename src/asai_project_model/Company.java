/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asai.project.model;

/**
 *
 * @author User
 */
import java.util.Date;

public class Company {
    private int id;
    private String codeCompany;
    private String descCompany;
    private Date createdAt;

    public Company(int id, String codeCompany, String descCompany, Date createdAt) {
        this.id = id;
        this.codeCompany = codeCompany;
        this.descCompany = descCompany;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String getDescCompany() {
        return descCompany;
    }

    public void setDescCompany(String descCompany) {
        this.descCompany = descCompany;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", codeCompany='" + codeCompany + '\'' +
                ", descCompany='" + descCompany + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
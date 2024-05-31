/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asai_project_model;

/**
 *
 * @author User
 */
import java.util.Date;

public class Material {
    private String codeMaterial;
    private String descMaterial;
    private String compMaterial;
    private Date createdAt;

    public Material(String codeMaterial, String descMaterial, String compMaterial, Date createdAt) {
        this.codeMaterial = codeMaterial;
        this.descMaterial = descMaterial;
        this.compMaterial = compMaterial;
        this.createdAt = createdAt;
    }

    public String getCodeMaterial() {
        return codeMaterial;
    }

    public void setCodeMaterial(String codeMaterial) {
        this.codeMaterial = codeMaterial;
    }

    public String getDescMaterial() {
        return descMaterial;
    }

    public void setDescMaterial(String descMaterial) {
        this.descMaterial = descMaterial;
    }

    public String getCompMaterial() {
        return compMaterial;
    }

    public void setCompMaterial(String compMaterial) {
        this.compMaterial = compMaterial;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Material{" +
                "codeMaterial='" + codeMaterial + '\'' +
                ", descMaterial='" + descMaterial + '\'' +
                ", compMaterial='" + compMaterial + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
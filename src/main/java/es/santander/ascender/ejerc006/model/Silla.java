package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Silla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private boolean tieneRespaldo;
    private boolean tieneCojin;
    private String color;

    public Silla() {}

    public Silla(Long id, String material, boolean tieneRespaldo, boolean tieneCojin, String color) {
        this.id = id;
        this.material = material;
        this.tieneRespaldo = tieneRespaldo;
        this.tieneCojin = tieneCojin;
        this.color = color;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public boolean isTieneRespaldo() { return tieneRespaldo; }
    public void setTieneRespaldo(boolean tieneRespaldo) { this.tieneRespaldo = tieneRespaldo; }
    public boolean isTieneCojin() { return tieneCojin; }
    public void setTieneCojin(boolean tieneCojin) { this.tieneCojin = tieneCojin; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}


package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private double altura;
    private double ancho;
    private double largo;

    public Mesa() {}

    public Mesa(Long id, String material, double altura, double ancho, double largo) {
        this.id = id;
        this.material = material;
        this.altura = altura;
        this.ancho = ancho;
        this.largo = largo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getAncho() { return ancho; }
    public void setAncho(double ancho) { this.ancho = ancho; }
    public double getLargo() { return largo; }
    public void setLargo(double largo) { this.largo = largo; }
}


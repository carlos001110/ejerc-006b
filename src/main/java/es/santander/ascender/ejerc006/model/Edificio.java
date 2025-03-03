package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private int numerosalas;
    private double superficie;

    public Edificio() {
    }

    public Edificio(Long id, String nombre, String direccion, int numerosalas, double superficie) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numerosalas = numerosalas;
        this.superficie = superficie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumerosalas() {
        return numerosalas;
    }

    public void setNumerosalas(int numerosalas) {
        this.numerosalas = numerosalas;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

}

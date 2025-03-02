package es.santander.ascender.ejerc006.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int capacidad;
    private boolean tieneVentanas;
    private String tipoPizarra;

    public Aula() {}

    public Aula(Long id, String nombre, int capacidad, boolean tieneVentanas, String tipoPizarra) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tieneVentanas = tieneVentanas;
        this.tipoPizarra = tipoPizarra;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public boolean isTieneVentanas() { return tieneVentanas; }
    public void setTieneVentanas(boolean tieneVentanas) { this.tieneVentanas = tieneVentanas; }
    public String getTipoPizarra() { return tipoPizarra; }
    public void setTipoPizarra(String tipoPizarra) { this.tipoPizarra = tipoPizarra; }
}

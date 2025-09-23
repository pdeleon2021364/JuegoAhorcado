package com.pdeleon.JuegoAhorcado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "palabras")
public class Palabra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoPalabra")
    private Integer codigoPalabra;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "pista1", nullable = false, length = 255)
    private String pista1;

    @Column(name = "pista2", nullable = false, length = 255)
    private String pista2;

    @Column(name = "pista3", nullable = false, length = 255)
    private String pista3;

    // Getters y Setters
    public Integer getCodigoPalabra() {
        return codigoPalabra;
    }

    public void setCodigoPalabra(Integer codigoPalabra) {
        this.codigoPalabra = codigoPalabra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPista1() {
        return pista1;
    }

    public void setPista1(String pista1) {
        this.pista1 = pista1;
    }

    public String getPista2() {
        return pista2;
    }

    public void setPista2(String pista2) {
        this.pista2 = pista2;
    }

    public String getPista3() {
        return pista3;
    }

    public void setPista3(String pista3) {
        this.pista3 = pista3;
    }
}

package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by 46989075y on 14/10/2016.
 */
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nombre;
    @JsonIgnore
    private LocalDate fecha;
    private int numcana;
    private int numasis;
    private int numreb;

    @ManyToOne
    private Equipo equipo;
    @Enumerated(EnumType.STRING)
    private Posicion posicion;

    public Jugador() {
    }

    public Jugador(String nombre, LocalDate fecha, int numcana, int numasis, int numreb, Posicion posicion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.numcana = numcana;
        this.numasis = numasis;
        this.numreb = numreb;
        this.posicion = posicion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getNumcana() {
        return numcana;
    }

    public void setNumcana(int numcana) {
        this.numcana = numcana;
    }

    public int getNumasis() {
        return numasis;
    }

    public void setNumasis(int numasis) {
        this.numasis = numasis;
    }

    public int getNumreb() {
        return numreb;
    }

    public void setNumreb(int numreb) {
        this.numreb = numreb;
    }

    public Posicion getPosicion() {

        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", numcana=" + numcana +
                ", numasis=" + numasis +
                ", numreb=" + numreb +
                ", posicion='" + posicion + '\'' +
                '}';
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

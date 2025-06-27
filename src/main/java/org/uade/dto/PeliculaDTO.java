package org.uade.dto;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;
import org.uade.model.CondicionesDescuento;

import java.util.List;

public class PeliculaDTO {
    private final int id;
    private final TipoGenero generoID;
    private final String nombrePelicula;
    private final int duracionEnMinutos;
    private final String director;
    private final List<String> actores;
    private final TipoProyeccion tipo;
    private final CondicionesDescuento condicionesDescuento;

    public PeliculaDTO(int id, TipoGenero generoID, String nombrePelicula, int duracionEnMinutos, String director, List<String> actores, TipoProyeccion tipo, CondicionesDescuento condicionesDescuento) {
        this.id = id;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.duracionEnMinutos = duracionEnMinutos;
        this.director = director;
        this.actores = actores;
        this.tipo = tipo;
        this.condicionesDescuento = condicionesDescuento;
    }

    public int getId() {
        return id;
    }

    public TipoGenero getGeneroID() {
        return generoID;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public String getDirector() {
        return director;
    }

    public List<String> getActores() {
        return actores;
    }

    public TipoProyeccion getTipo() {
        return tipo;
    }

    public CondicionesDescuento getCondicionesDescuento() {
        return condicionesDescuento;
    }
}

package org.uade.model;

import org.uade.enums.TipoGenero;
import org.uade.enums.TipoProyeccion;

import java.util.List;

public class PeliculaModel {

    private int id;
    private TipoGenero generoID;
    private String nombrePelicula;
    private int duracionEnMinutos;
    private String director;
    private List<String> actores;
    private TipoProyeccion tipo;
    private CondicionesDescuentoModel condicionesDescuento;

    public PeliculaModel(int id, TipoGenero generoID, String director, int duracionEnMinutos, String nombrePelicula, TipoProyeccion tipo, List<String> actores, CondicionesDescuentoModel descuento) {
        this.id = id;
        this.director = director;
        this.duracionEnMinutos = duracionEnMinutos;
        this.generoID = generoID;
        this.nombrePelicula = nombrePelicula;
        this.tipo = tipo;
        this.actores = actores;
        this.condicionesDescuento = descuento;
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

    public CondicionesDescuentoModel getCondicionesDescuento() {
        return condicionesDescuento;
    }

    public void setGeneroID(TipoGenero generoID){
        this.generoID = generoID;
    }

    public int getPeliculaId(){
        return id;
    }

    public void setActor(String actor){
        actores.add(actor);
    }
}
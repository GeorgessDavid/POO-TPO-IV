package org.uade.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Funcion {

    private Pelicula pelicula;
    private int funcionID;
    private String horario;
    private Date fecha;
    private List<Entrada> entradas;
    private Sala sala;

    public Funcion(Date fecha, int funcionID, String horario,List<Entrada> entradas, Sala sala, Pelicula pelicula) {
    	this.fecha = fecha;
    	this.funcionID = funcionID;
        this.entradas = entradas;
    	this.horario = horario;
    	this.sala = sala;
    	this.pelicula = pelicula;
    }


    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getFuncionID() {
        return funcionID;
    }

    public String getHorario() {
        return horario;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public Sala getSala() {
        return sala;
    }

    public Date getFecha(){
        return fecha;
    }

    public float calcularMontoPorEntradaDeLaPelicula() {
        float total = 0.0F;

        for (Entrada entrada : entradas) {
            float precioEntrada = entrada.getPrecio() - (entrada.getPrecio() * pelicula.getCondicionesDescuento().getDescuento());

            total += precioEntrada;
        }

        return total;
    }

}
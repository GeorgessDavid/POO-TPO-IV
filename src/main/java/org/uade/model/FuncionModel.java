package org.uade.model;

import java.util.Date;
import java.util.List;

public class FuncionModel {

    private PeliculaModel pelicula;
    private int funcionID;
    private String horario;
    private Date fecha;
    private List<EntradaModel> entradas;
    private SalaModel sala;

    public FuncionModel(Date fecha, int funcionID, String horario, List<EntradaModel> entradas, SalaModel sala, PeliculaModel pelicula) {
    	this.fecha = fecha;
    	this.funcionID = funcionID;
        this.entradas = entradas;
    	this.horario = horario;
    	this.sala = sala;
    	this.pelicula = pelicula;
    }


    public PeliculaModel getPelicula() {
        return pelicula;
    }

    public int getFuncionID() {
        return funcionID;
    }

    public String getHorario() {
        return horario;
    }

    public List<EntradaModel> getEntradas() {
        return entradas;
    }

    public SalaModel getSala() {
        return sala;
    }

    public Date getFecha(){
        return fecha;
    }

    public float calcularMontoPorEntradaDeLaPelicula() {
        float total = 0.0F;

        for (EntradaModel entrada : entradas) {
            float precioEntrada = entrada.getPrecio() - (entrada.getPrecio() * pelicula.getCondicionesDescuento().getDescuento());

            total += precioEntrada;
        }

        return total;
    }

}
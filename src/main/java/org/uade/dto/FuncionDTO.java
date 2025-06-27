package org.uade.dto;

import org.uade.model.Entrada;
import org.uade.model.Pelicula;
import org.uade.model.Sala;

import java.util.Date;
import java.util.List;

public class FuncionDTO {
    private final Pelicula pelicula;
    private final int funcionID;
    private final String horario;
    private final Date fecha;
    private final List<Entrada> entradas;
    private final Sala sala;

    public FuncionDTO(Pelicula pelicula, int funcionID, String horario, Date fecha, List<Entrada> entradas, Sala sala) {
        this.pelicula = pelicula;
        this.funcionID = funcionID;
        this.horario = horario;
        this.fecha = fecha;
        this.entradas = entradas;
        this.sala = sala;
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

    public Date getFecha() {
        return fecha;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public Sala getSala() {
        return sala;
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

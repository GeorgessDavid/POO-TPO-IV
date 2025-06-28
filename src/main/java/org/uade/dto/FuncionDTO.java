package org.uade.dto;

import org.uade.model.EntradaModel;
import org.uade.model.PeliculaModel;
import org.uade.model.SalaModel;

import java.util.Date;
import java.util.List;

public class FuncionDTO {
    private final PeliculaModel pelicula;
    private final int funcionID;
    private final String horario;
    private final Date fecha;
    private final List<EntradaModel> entradas;
    private final SalaModel sala;

    public FuncionDTO(PeliculaModel pelicula, int funcionID, String horario, Date fecha, List<EntradaModel> entradas, SalaModel sala) {
        this.pelicula = pelicula;
        this.funcionID = funcionID;
        this.horario = horario;
        this.fecha = fecha;
        this.entradas = entradas;
        this.sala = sala;
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

    public Date getFecha() {
        return fecha;
    }

    public List<EntradaModel> getEntradas() {
        return entradas;
    }

    public SalaModel getSala() {
        return sala;
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

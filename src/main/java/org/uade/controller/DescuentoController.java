package org.uade.controller;

import org.uade.enums.TipoTarjeta;
import org.uade.model.CondicionesDescuentoModel;
import org.uade.model.TarjetaDescuentoModel;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DescuentoController {
	private static DescuentoController instance;
	private final List<CondicionesDescuentoModel> descuento;
	
    private DescuentoController() {
    	descuento = new ArrayList<>();
    	CondicionesDescuentoModel CondicionesDescuento = new CondicionesDescuentoModel(new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuentoModel>());
    	descuento.add(CondicionesDescuento);
    }

	public static DescuentoController getInstance(){
		if(instance==null) instance = new DescuentoController();

		return instance;
	}

	public void altaDescuento(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjeta, List<TarjetaDescuentoModel> tarjetaDescuento){
		if(buscarDescuento(fchDesde,fchHasta)!= null) return;

		if (fchDesde.after(fchHasta)) throw new IllegalArgumentException("La fecha de inicio no puede ser mayor a la fecha de fin.");
		descuento.add(new CondicionesDescuentoModel(fchDesde, fchHasta, diaSemana, porcentaje, tipoTarjeta, tarjetaDescuento));
	}

	public void bajaDescuento(){}

	public void modificarDescuento(){}

	private CondicionesDescuentoModel buscarDescuento(Date fechaDesde, Date fechaHasta) {

		for(CondicionesDescuentoModel cd : descuento) {
			if(cd.getFchDesde().equals(fechaDesde) && cd.getFchHasta().equals(fechaHasta)) return cd;
		}

		return null;
	}
}
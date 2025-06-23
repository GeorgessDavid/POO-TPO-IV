package org.uade.controller;

import org.uade.enums.TipoTarjeta;
import org.uade.model.CondicionesDescuento;
import org.uade.model.TarjetaDescuento;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DescuentoController {
	
	
	private static DescuentoController instance;
	private List<CondicionesDescuento> descuento;
	
    private DescuentoController() {
    	descuento = new ArrayList<CondicionesDescuento>();
    	CondicionesDescuento CondicionesDescuento = new CondicionesDescuento(new Date(), new Date(), 5, 50, TipoTarjeta.PAMI, new ArrayList<TarjetaDescuento>());
    	descuento.add(CondicionesDescuento);
    }

	public static DescuentoController getInstance(){
		if(instance==null) instance = new DescuentoController();

		return instance;
	}

	public void altaDescuento(Date fchDesde, Date fchHasta, int diaSemana, float porcentaje, TipoTarjeta tipoTarjeta, List<TarjetaDescuento> tarjetaDescuento){
		if(buscarDescuento(fchDesde,fchHasta)!= null) return;

		descuento.add(new CondicionesDescuento(fchDesde, fchHasta, diaSemana, porcentaje, tipoTarjeta, tarjetaDescuento));
	}

	public void bajaDescuento(){}

	public void modificarDescuento(){}

	private CondicionesDescuento buscarDescuento(Date fechaDesde, Date fechaHasta){

		for(CondicionesDescuento cd : descuento){
			if(cd.getFchDesde().equals(fechaDesde) && cd.getFchHasta().equals(fechaHasta)) return cd;
		}
		return null;
	}
}
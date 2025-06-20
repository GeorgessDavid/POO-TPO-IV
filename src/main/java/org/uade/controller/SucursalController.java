package org.uade.controller;

import org.uade.model.Sucursal;

import java.util.List;
import java.util.ArrayList;

public class SucursalController {

    private static SucursalController instance;
	private List<Sucursal> sucursales;
		
    public SucursalController() {
    	sucursales = new ArrayList<Sucursal>();
    	sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }

    public static SucursalController getInstance(){
        if(instance==null) instance = new SucursalController();

        return instance;
    }

    public void agregarSucursal(int id, String denom, String dir) {
        // TODO implement here
    }
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        // TODO implement here
    }

}
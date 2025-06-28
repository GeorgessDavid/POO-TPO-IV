package org.uade.controller;

import org.uade.model.Sala;
import org.uade.model.Sucursal;

import java.util.List;
import java.util.ArrayList;

public class SucursalController {

    private static SucursalController instance;
	private List<Sucursal> sucursales;

    private int contadorId;
		
    public SucursalController() {
    	sucursales = new ArrayList<Sucursal>();
    	sucursales.add(new Sucursal(1, "Barracas", "Av Montes de Oca 1100", null));
    }

    public static SucursalController getInstance(){
        if(instance==null) instance = new SucursalController();

        return instance;
    }

    public void agregarSucursal(String denom, String dir,List<Sala> arr) {
        if(buscarSucursal(contadorId)!=null) return;

        sucursales.add(new Sucursal(contadorId,denom,dir,arr));
        contadorId++;
    }
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        Sucursal s = buscarSucursal(idSucursal);
        if(s==null) return;

        s.setSala(new Sala(salaID, denom, nroasientos));
    }

    private Sucursal buscarSucursal(int id){
        for(Sucursal s : sucursales){
            if(s.getSucursalID()==id) return s;
        }
        return null;
    }

}
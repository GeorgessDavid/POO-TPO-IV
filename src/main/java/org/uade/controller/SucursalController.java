package org.uade.controller;

import org.uade.model.SalaModel;
import org.uade.model.SucursalModel;

import java.util.List;
import java.util.ArrayList;

public class SucursalController {

    private static SucursalController instance;
	private List<SucursalModel> sucursales;

    private int contadorId;
		
    private SucursalController() {
    	sucursales = new ArrayList<>();
    }

    public static SucursalController getInstance(){
        if(instance==null) instance = new SucursalController();

        return instance;
    }

    public void agregarSucursal(String denom, String dir,List<SalaModel> arr) {
        if(buscarSucursal(contadorId)!=null) return;

        sucursales.add(new SucursalModel(contadorId,denom,dir,arr));
        contadorId++;
    }
    public void agregarSala(int idSucursal, int salaID, String denom, int nroasientos) {
        SucursalModel s = buscarSucursal(idSucursal);
        if(s==null) return;

        s.setSala(new SalaModel(salaID, denom, nroasientos));
    }

    public SucursalModel buscarSucursal(int id){
        for(SucursalModel s : sucursales){
            if(s.getSucursalID()==id) return s;
        }
        return null;
    }

}
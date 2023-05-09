package org.p4.adc.Graficos.Modelo;

import org.p4.adc.Graficos.Vista.Vista;

public class ImplementacionModelo implements Modelo{
    private Vista vista;
    @Override
    public void setVista(Vista vista) {
        this.vista=vista;
    }

    public void recSys(String method){

    }

}

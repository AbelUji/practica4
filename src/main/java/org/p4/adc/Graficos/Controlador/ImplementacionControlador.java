package org.p4.adc.Graficos.Controlador;

import org.p4.adc.Graficos.Modelo.Modelo;
import org.p4.adc.Graficos.Vista.Vista;
import org.p4.adc.Interfaces.Distance;

public class ImplementacionControlador implements Controlador{
    private Vista vista;
    private Modelo modelo;
    @Override
    public void setVista(Vista vista) {
        this.vista=vista;
    }

    @Override
    public void setModelo(Modelo modelo) {
        this.modelo=modelo;

    }

    public void setCancionesRecomendadas(){

    }

    public void abrirSegundaVentana(String prueba,String algoritmo, Distance distancia){

    }
}

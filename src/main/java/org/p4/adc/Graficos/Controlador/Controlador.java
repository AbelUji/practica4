package org.p4.adc.Graficos.Controlador;

import org.p4.adc.Graficos.Modelo.Modelo;
import org.p4.adc.Graficos.Vista.Vista;
import org.p4.adc.Interfaces.Distance;

public interface Controlador {
    void setVista(Vista vista);
    void setModelo(Modelo modelo);

    void abrirSegundaVentana(String prueba,String algoritmo, Distance distancia);
}

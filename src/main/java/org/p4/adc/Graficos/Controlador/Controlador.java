package org.p4.adc.Graficos.Controlador;

import org.p4.adc.Excepciones.ClusterException;
import org.p4.adc.Graficos.Modelo.Modelo;
import org.p4.adc.Graficos.Vista.Vista;
import org.p4.adc.Interfaces.Distance;

import java.io.IOException;

public interface Controlador {
    void setVista(Vista vista);
    void setModelo(Modelo modelo);

    void abrirSegundaVentana(String prueba,String algoritmo, Distance distancia) throws IOException, ClusterException;
    void setCancionesRecomendadas(String metodo, Distance distancia) throws ClusterException, IOException;
}

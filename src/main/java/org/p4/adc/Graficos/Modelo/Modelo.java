package org.p4.adc.Graficos.Modelo;

import org.p4.adc.Clases.RecSys;
import org.p4.adc.Excepciones.ClusterException;
import org.p4.adc.Graficos.Vista.Vista;
import org.p4.adc.Interfaces.Distance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Modelo {
    void setVista(Vista vista);
    void recSys(String method, Distance distancia) throws IOException, ClusterException;
    RecSys getRecsys();
    List<String> anadirCanciones(String fichero) throws IOException;
}

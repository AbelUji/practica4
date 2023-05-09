package org.p4.adc.Graficos.Vista;

import org.p4.adc.Graficos.Controlador.Controlador;
import org.p4.adc.Graficos.Modelo.Modelo;

import java.io.IOException;

public interface Vista {
    void prepararStage();
    void montarStage();
    void crearStage() throws IOException;

    void setControlador(Controlador controlador);
    void setModelo(Modelo modelo);
}

package org.p4.adc.Graficos.Vista;

import java.io.IOException;

public interface Vista {
    void prepararStage();
    void montarStage();
    void crearStage() throws IOException;
}

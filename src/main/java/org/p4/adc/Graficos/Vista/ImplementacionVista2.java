package org.p4.adc.Graficos.Vista;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ImplementacionVista2 implements Vista{
    private StackPane root;
    private Stage stage;

    public ImplementacionVista2(Stage stage){
        this.stage=stage;
        root = new StackPane();
    }
    @Override
    public void prepararStage() {
        stage.setTitle("Recommended titles");
        stage.setScene(new Scene(root, 200, 450));
    }

    public void crearNumRec(){

    }

    @Override
    public void montarStage() {

    }

    @Override
    public void crearStage() throws IOException {

    }
}

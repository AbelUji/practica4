package org.p4.adc.Graficos.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.p4.adc.Graficos.Controlador.Controlador;
import org.p4.adc.Graficos.Modelo.Modelo;
import org.p4.adc.Interfaces.Algorithm;
import org.p4.adc.Interfaces.Distance;

import java.io.IOException;

public class ImplementacionVista2 implements Vista{
    private StackPane root;
    private Stage stage;
    private VBox vNumRec, estruc_global;
    private Controlador controlador;
    private Modelo modelo;
    private Spinner<Double> spinner;
    private String cancionElegida, algoritmoElegido;
    private Distance distanciaElegida;
    private ListView lista;

    public ImplementacionVista2(Stage stage, String recomendada, String algor, Distance distancia){
        this.stage=stage;
        root = new StackPane();
        this.cancionElegida=recomendada;
        this.algoritmoElegido=algor;
        this.distanciaElegida=distancia;
    }
    @Override
    public void prepararStage() {
        stage.setTitle("Recommended titles");
        stage.setScene(new Scene(root, 200, 450));
    }

    public void crearNumRec(){
        Label label_rec_type = new Label("Number of recommendations");
        spinner = new Spinner<Double>();
        SpinnerValueFactory<Double> valueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(1, 10);
        spinner.setValueFactory(valueFactory);

        vNumRec= new VBox(label_rec_type, spinner);
    }

    public void recomendadas(){
        Label label_rec = new Label("If you liked '"+cancionElegida+"' you might like");
        HBox hlabel_rec = new HBox(label_rec);


    }

    @Override
    public void montarStage() {
        estruc_global=new VBox(vNumRec);
        root.getChildren().add(estruc_global);
    }

    @Override
    public void crearStage() throws IOException {
        crearNumRec();
        montarStage();
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador=controlador;
    }

    @Override
    public void setModelo(Modelo modelo) {

    }
}

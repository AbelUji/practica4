package org.p4.adc.Graficos.Vista;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.p4.adc.Excepciones.ClusterException;
import org.p4.adc.Graficos.Controlador.Controlador;
import org.p4.adc.Graficos.Modelo.Modelo;
import org.p4.adc.Interfaces.Algorithm;
import org.p4.adc.Interfaces.Distance;

import java.io.IOException;

public class ImplementacionVista2 implements Vista{
    private StackPane root;
    private Stage stage;
    private VBox vNumRec, estruc_global, vLista;
    private Controlador controlador;
    private Modelo modelo;
    private Spinner<Integer> spinner;
    private String cancionElegida, algoritmoElegido;
    private Distance distanciaElegida;
    private ListView<String> lista;

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

    public void crearNumRec() throws ClusterException, IOException {
        controlador.setCancionesRecomendadas(algoritmoElegido,distanciaElegida);
        Label label_rec_type = new Label("Number of recommendations (Maximo: "+" )");


        spinner = new Spinner<Integer>();
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, modelo.getRecsys().getTamano(cancionElegida),14);
        spinner.setValueFactory(valueFactory);

        lista=new ListView<>(FXCollections.observableArrayList(modelo.getRecsys().recommend(cancionElegida, spinner.getValue())));

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                lista=new ListView<>(FXCollections.observableArrayList(modelo.getRecsys().recommend(cancionElegida, spinner.getValue())));

            }
        });
        vNumRec= new VBox(label_rec_type, spinner);
    }

    public void recomendadas(){
        Label label_rec = new Label("If you liked '"+cancionElegida+"' you might like");
        HBox hlabel_rec = new HBox(label_rec);

        vLista=new VBox(hlabel_rec,lista);
    }

    @Override
    public void montarStage() {
        estruc_global=new VBox(vNumRec,vLista);
        root.getChildren().add(estruc_global);
    }

    @Override
    public void crearStage() throws IOException, ClusterException {
        crearNumRec();
        recomendadas();
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

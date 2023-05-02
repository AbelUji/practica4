package org.p4.adc.Graficos.Vista;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jfr.Event;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionVista implements Vista{
    private VBox estruc_global, rec_radio, dist_radio, lista_canciones,bot_aceptar;
    private StackPane root;
    private Stage stage;
    private Button boton;
    private ListView lista;
    private RadioButton rec_song_feature, rec_guess_genre, dist_euclid, dist_manh;

    public ImplementacionVista(Stage stage){
        this.stage=stage;
        root = new StackPane();
    }

    public void prepararStage(){
        stage.setTitle("Song Recommender");
        stage.setScene(new Scene(root, 400, 700));
    }
    public void crearRecType(){
        Label label_rec_type = new Label("Recommendation Type");
        HBox hlabel_rec_type = new HBox(label_rec_type);
        hlabel_rec_type.setAlignment(Pos.BASELINE_LEFT);
        hlabel_rec_type.setSpacing(5);

        ToggleGroup grupo = new ToggleGroup();
        rec_song_feature = new RadioButton("Recommended based on song features");
        rec_guess_genre = new RadioButton("Recommended based on guessed genre");

        rec_song_feature.setToggleGroup(grupo);
        rec_guess_genre.setToggleGroup(grupo);

        VBox vRadio= new VBox(rec_song_feature, rec_guess_genre);
        vRadio.setSpacing(3);
        rec_radio = new VBox(hlabel_rec_type, vRadio);
    }

    public void crearDistType(){
        Label label_dist_type = new Label("Distance Type");
        HBox hlabel_dist_type = new HBox(label_dist_type);
        hlabel_dist_type.setAlignment(Pos.BASELINE_LEFT);
        hlabel_dist_type.setSpacing(5);

        ToggleGroup grupo = new ToggleGroup();
        dist_euclid = new RadioButton("Euclidean");
        dist_manh = new RadioButton("Manhattan");

        dist_euclid.setToggleGroup(grupo);
        dist_manh.setToggleGroup(grupo);

        VBox vRadio= new VBox(dist_euclid, dist_manh);
        vRadio.setSpacing(3);
        dist_radio = new VBox(hlabel_dist_type, vRadio);
    }

    public void crearListaCanciones() throws IOException {
        Label label_title = new Label("Song Titles");
        HBox hlabel_title = new HBox(label_title);
        hlabel_title.setAlignment(Pos.BASELINE_LEFT);
        hlabel_title.setSpacing(5);

        String sep = System.getProperty("file.separator");
        String ruta = "src\\main\\resources\\files";
        lista = new ListView<>(FXCollections.observableArrayList(anadirCanciones(ruta+sep+"songs_train_names.csv")));
        lista.getSelectionModel().selectedItemProperty().addListener((item, valorInicial, valorActual) -> {
            boton.setText("Recommended on "+ valorActual);
        });
        lista_canciones=new VBox(label_title,lista);
    }

    public void dobleClickLista(){
        lista.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
    }

    private List<String> anadirCanciones(String fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String line;
        List<String> names = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            names.add(line);
        }
        br.close();
        return names;
    }

    public void crearBotonAceptar(){
        boton = new Button("Recommended");

        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                comprobaciones();
            }
        });
        bot_aceptar=new VBox(boton);
    }

    private boolean comprobaciones(){
        if(!dist_euclid.isSelected() || !dist_manh.isSelected() || !rec_guess_genre.isSelected() || !rec_song_feature.isSelected() || lista.getSelectionModel().getSelectedIndex()==-1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
        }
        return false;
    }

    public void montarStage(){
        estruc_global = new VBox(rec_radio,dist_radio,lista_canciones,bot_aceptar);
        root.getChildren().add(estruc_global);
    }


    public void crearStage() throws IOException {
        prepararStage();
        crearRecType();
        crearDistType();
        crearListaCanciones();
        crearBotonAceptar();
        montarStage();
        stage.show();
    }
}

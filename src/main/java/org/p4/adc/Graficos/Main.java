package org.p4.adc.Graficos;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Titulo Pestaña
        stage.setTitle("Song Recommender");
        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 400, 700));
        stage.show();

        //Sector Tipo Recomendado
        Label label_rec_type = new Label("Recommendation Type");
        HBox hlabel_rec_type = new HBox(label_rec_type);
        hlabel_rec_type.setAlignment(Pos.BASELINE_LEFT);
        hlabel_rec_type.setSpacing(5);

        ToggleGroup grupo = new ToggleGroup();
        RadioButton rec_song_feature = new RadioButton("Recommended based on song features");
        RadioButton rec_guess_genre = new RadioButton("Recommended based on guessed genre");

        rec_song_feature.setToggleGroup(grupo);
        rec_guess_genre.setToggleGroup(grupo);

        VBox vRadio= new VBox(rec_song_feature, rec_guess_genre);
        vRadio.setSpacing(3);




        VBox rec_radio = new VBox(hlabel_rec_type, vRadio);

        VBox estruc_global = new VBox(rec_radio);
        root.getChildren().add(estruc_global);

    }
}

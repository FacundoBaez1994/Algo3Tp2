package edu.fiuba.algo3.vista;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VistaDeLaPartida {
    private final Stage stage;
    private GridPaneGrilla vistaGrilla;

    public VistaDeLaPartida (Stage stage) {
        super();
        this.stage = stage;
        this.vistaGrilla = new GridPaneGrilla();
    }

    public void mostrarPantalla() {

        HBox root = new HBox(0);
        root.getChildren().addAll(this.vistaGrilla);
        Scene scene = new Scene(root, 500, 500);
        this.stage.setTitle("GPS CHALLENGE");
        this.stage.setScene(scene);
        stage.show();

    }
}

package edu.fiuba.algo3.controlador;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PopupSorpresa extends javafx.stage.Popup {
    private String texto;
    private Popup popup;

    public PopupSorpresa(String texto) {
        this.texto = texto;
        Label label = new Label(this.texto);
        this.popup = new javafx.stage.Popup();
        label.setMinWidth(10);
        label.setMinHeight(10);

        Button button = new Button("Cerrar");
        button.setOnAction(new HandlerBotonPopupSorpresa ( this.popup));

        StackPane root =  new StackPane();

        VBox contenedorVertical = new VBox (label, button);
        contenedorVertical.setSpacing (1);
        contenedorVertical.setPadding(new Insets(1));
        contenedorVertical.setAlignment(Pos.CENTER);

        Image imagen = new Image("file:src/recursos/img/ladrillos.PNG",300,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, contenedorVertical);

        this.popup.getContent().add(root);
    }

    public void mostrar (Stage stage) {
        this.popup.show(stage);
    }
}

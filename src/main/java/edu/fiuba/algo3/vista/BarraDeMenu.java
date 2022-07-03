package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu {
    private MenuItem itemDescripcionDeMovimientos;
    private MenuItem itemAcercaDe;
    private Menu menuAcercaDe;
    private MenuBar barraDeMenu;
    private Menu menuAyuda;
    private Menu menuMusica;
    private Menu subMenuAyudaMovimientos;
    private MenuItem musicaOff;
    private MenuItem musicaOn;

    public BarraDeMenu(Stage stage){
        this.barraDeMenu = new MenuBar();
        this.menuAyuda = new Menu("Ayuda");
        this.menuAcercaDe = new Menu("Acerca de...");
        this.itemAcercaDe = new MenuItem(  "Creado por: "+ '\n'+"Baez, Facundo"+ '\n'+ "Piperno, Agustín"+ '\n'+"Torales, Cristian"+ '\n'+ "Viñas, Matías"+ '\n'+ "© Todos los derechos reservados");
        this.menuMusica = new Menu("Música");
        this.musicaOff = new MenuItem("Silenciar música");
        this.subMenuAyudaMovimientos = new Menu("Movimientos");
        this.itemDescripcionDeMovimientos = new MenuItem("Movimiento con WASD");

        this.musicaOn = new MenuItem("Reproducir música");
        this.menuAcercaDe.getItems().add(this.itemAcercaDe);

        this.subMenuAyudaMovimientos.getItems().add(this.itemDescripcionDeMovimientos);
        this.menuAyuda.getItems().add(this.subMenuAyudaMovimientos);


        this.menuMusica.getItems().add(this.musicaOn);
        this.menuMusica.getItems().add(this.musicaOff);
        this.barraDeMenu.getMenus().add(this.menuAcercaDe);
        this.barraDeMenu.getMenus().add(this.menuMusica);
        this.barraDeMenu.getMenus().add(this.menuAyuda);
        this.barraDeMenu.prefWidthProperty().bind(stage.widthProperty());
        this.accionarOpcionSilenciarMusica();
        this.accionarOpcionReproducirMusica();
    }
    public MenuBar getMenuBar(){
        return this.barraDeMenu;
    }
    private void accionarOpcionSilenciarMusica(){
        this.musicaOff.setOnAction(e -> {
            HandlerTemaPrincipal.detenerSonido();
        });
    }
    private void accionarOpcionReproducirMusica(){
        this.musicaOn.setOnAction(e -> {
            HandlerTemaPrincipal.reproducirSonido();
        });
    }
}

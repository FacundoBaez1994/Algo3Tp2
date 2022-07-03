package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.sonido.HandlerTemaPrincipal;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu {
    private MenuItem itemAcercaDe;
    private Menu menuAcercaDe;
    private MenuBar barraDeMenu;
    private Menu menuAyuda;
    private Menu menuMusica;
    private MenuItem musicaOff;
    private MenuItem musicaOn;

    public BarraDeMenu(Stage stage){
        this.barraDeMenu = new MenuBar();
        this.menuAyuda = new Menu("Ayuda");
        this.menuAcercaDe = new Menu("Acerca de...");
        this.itemAcercaDe = new MenuItem(  "Creado por: "+ '\n'+"Baez, Facundo"+ '\n'+ "Piperno, Agustín"+ '\n'+"Torales, Cristian"+ '\n'+ "Viñas, Matías"+ '\n'+ "© Todos los derechos reservados");
        this.menuMusica = new Menu("Música");
        this.musicaOff = new MenuItem("Silenciar música");

        this.agregarItemAMenuDeAyuda("Objetivo", "GPS CHALLENGE un juego de estrategia por turnos, donde el escenario es una ciudad\n" +
                " y el objetivo es guiar a un vehículo a la meta\n" +
                "en la menor cantidad de movimientos posibles");
        this.agregarItemAMenuDeAyuda("Movimientos", "El movimiento del Vehiculo se realiza con con WASD");
        this.agregarItemAMenuDeAyuda("Obstaculos", "Pozos: Le suma 3 movimientos de penalización a autos y motos.\n" +
                "Para una 4x4 penaliza en 2 movimientos luego de atravesar 3 pozos.\n" +
                "- Piquete: Autos y 4x4 deben pegar la vuelta, no pueden pasar. \n" +
                "Las motos pueden pasar con una penalización de 2 movimientos.\n" +
                "- Control Policial: Para todos los vehículos la penalización es de 3 movimientos, \n" +
                "sin embargo la probabilidad de que el vehículo quede demorado por el control y \n" +
                " sea penalizado es de 0,3 para las 4x4, 0,5 para los autos y 0,8 para las motos.");
        this.agregarItemAMenuDeAyuda("Sorpresas", "\\- Sorpresa Favorable: Resta el 20 %  de los movimientos hechos.\n" +
                "- Sorpresa Desfavorable: Suma el 25 $\\%$  de los movimientos hechos.\n" +
                "- Sorpresa Cambio de Vehículo: Cambia el vehículo del jugador. Si es una moto, la convierte en auto.\n" +
                " Si es un auto lo convierte en 4x4. Si es una 4x4 la convierte en moto. ");


        this.musicaOn = new MenuItem("Reproducir música");
        this.menuAcercaDe.getItems().add(this.itemAcercaDe);

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

    private void agregarItemAMenuDeAyuda(String subMenu, String item){
        //this.subMenuAyudaMovimientos = new Menu(subMenu);
        Menu submenu = new Menu(subMenu);
        //this.itemDescripcionDeMovimientos = new MenuItem(item);
        MenuItem itemMenu = new MenuItem(item);
        submenu.getItems().add(itemMenu);

        this.menuAyuda.getItems().add(submenu);

    }
}

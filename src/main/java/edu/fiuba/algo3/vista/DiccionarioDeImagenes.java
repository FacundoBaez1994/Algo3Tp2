package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.grilla.Meta;
import edu.fiuba.algo3.modelo.obstaculo.ControlPolicial;
import edu.fiuba.algo3.modelo.obstaculo.Piquete;
import edu.fiuba.algo3.modelo.obstaculo.Pozo;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Auto;
import edu.fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculo.Moto;
import javafx.scene.image.ImageView;


import java.util.Dictionary;
import java.util.Hashtable;

public class DiccionarioDeImagenes {
    private Dictionary dicc = new Hashtable();

    private static final int ALTURA_UBICABLE = 30;
    private static final int ANCHURA_UBICABLE = 30;

    private static String rutaMoto = "file:src/recursos/img/moto.png";
    private static String rutaCuatroPorCuatro = "file:src/recursos/img/cuatroPorCuatro.png";
    private static String rutaAuto = "file:src/recursos/img/auto.png";
    private static String rutaPozo = "file:src/recursos/img/pozo.png";
    private static String rutaPiquete = "file:src/recursos/img/piquete.png";
    private static String rutaControlPolicial = "file:src/recursos/img/controlPolicial.png";
    private static String rutaSorpresa = "file:src/recursos/img/Sorpresa.png";
    private static String rutaMeta = "file:src/recursos/img/meta.png";


    public DiccionarioDeImagenes() {
        dicc.put(Moto.class,rutaMoto);
        dicc.put(CuatroPorCuatro.class, rutaCuatroPorCuatro);
        dicc.put(Auto.class,rutaAuto);
        dicc.put(Pozo.class,rutaPozo);
        dicc.put(Piquete.class,rutaPiquete);
        dicc.put(ControlPolicial.class,rutaControlPolicial);
        dicc.put(SorpresaFavorable.class, rutaSorpresa);
        dicc.put(SorpresaNoFavorable.class, rutaSorpresa);
        dicc.put(CambioDeVehiculo.class, rutaSorpresa);
        dicc.put(Meta.class,rutaMeta);
    }

    public ImageView get (Class className) {
        String ruta = (String)dicc.get(className);
        ImageView img;
        img = new ImageView(ruta);
        img.setFitHeight(ALTURA_UBICABLE);
        img.setFitWidth(ANCHURA_UBICABLE);
        return img;
    }
}
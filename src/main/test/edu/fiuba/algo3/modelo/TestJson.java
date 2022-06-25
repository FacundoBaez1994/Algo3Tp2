package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.archivador.FormatoJson;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.PuntajesAltos;
import edu.fiuba.algo3.modelo.sorpresa.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.sorpresa.SorpresaNoFavorable;
import edu.fiuba.algo3.modelo.vehiculo.Vehiculo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestJson {
    @Test
    public void testSeExportaUnArchivoJson(){

        //Arrange
        Jugador jugador1 = new Jugador("nombre1", 1);
        Jugador jugador2 = new Jugador("nombre2", 2);
        Jugador jugador3 = new Jugador("nombre3", 3);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador1);
        jugadores.add(jugador1);

        FormatoJson formatoJson = new FormatoJson();
        formatoJson.setFilePath("puntajesAltosTestExportar.json");

        //Act
        formatoJson.exportar(jugadores);
        

    }
    @Test
    public void testSeImportaUnArchivoJson(){

        //Arrange

        FormatoJson formatoJson = new FormatoJson();
        formatoJson.setFilePath("puntajesAltosTestImportar.json");

        //Act
        ArrayList<Jugador> jugadores = formatoJson.importar();

        //Assert
        assertEquals( jugadores.size(), 3);
    }
}

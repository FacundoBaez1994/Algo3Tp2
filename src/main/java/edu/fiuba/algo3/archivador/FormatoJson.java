package edu.fiuba.algo3.archivador;

import edu.fiuba.algo3.modelo.juego.Jugador;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class FormatoJson implements Archivador {
    private String filePath = "";
    static int bufferLength = 300;

    public FormatoJson(){
        this.filePath = "puntajesAltos.json";
    };

    public void setFilePath(String filePath){
        this.filePath = filePath;
    };

    public ArrayList<Jugador> importar() {
        try {

            FileReader input = new FileReader(filePath);
            char[] buffer = new char[bufferLength];
            input.read(buffer);
            String string_json = String.valueOf(buffer);
            JSONObject mainJo = new JSONObject(string_json);

            ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

            JSONArray ja = mainJo.getJSONArray("jugadores");

            for (int i = 0; i < ja.length(); i++) {

                JSONObject jo = ja.getJSONObject(i);
                Jugador jugador = new Jugador(jo.getString("nickname"), jo.getInt("puntaje"));
                jugadores.add(jugador);
            }

            input.close();

            return jugadores;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportar(ArrayList<Jugador> jugadores) {

        try {
            JSONObject mainJo = new JSONObject();
            JSONArray ja = new JSONArray();
            Writer output = new FileWriter(filePath);

            int counter = 0;

            for (Jugador jugador : jugadores) {
                JSONObject jo = new JSONObject();
                jo.put("nickname", jugador.getNickname());
                jo.put("puntaje", jugador.getPuntaje());
                ja.put(jo);
                if(counter < 5) counter++; else break;
            }
            mainJo.put("jugadores", ja);

            mainJo.write(output);

            output.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
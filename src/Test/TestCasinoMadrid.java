package Test;

import BaseDatos.CasinoMadrid;

import java.util.Date;

public class TestCasinoMadrid {
    public static void main(String[] args) {
        Date date = new Date();
        CasinoMadrid casinoMadrid = new CasinoMadrid();
        casinoMadrid.parseadorMadrid("casinomadrid","Bundesliga", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga", date);
    }
}

package Test;

import BaseDatos.CasinoMadrid;

public class TestCasinoMadrid {
    public static void main(String[] args) {
        CasinoMadrid casinoMadrid = new CasinoMadrid();
        casinoMadrid.parseadorMadrid("CasinoMadrid","Bundesliga", "https://apuestas.casinogranmadridonline.es/es/futbol/alemania/268-bundesliga");
    }
}

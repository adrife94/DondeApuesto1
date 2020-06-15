package Test;

import BaseDatos.CasinoBarcelona;

import java.util.Date;

public class TestCasinoBarcelona {
    public static void main(String[] args) {
        Date date = new Date();
        CasinoBarcelona casinoBarcelona = new CasinoBarcelona();
        casinoBarcelona.parseadorBarcelona("casinobarcelona","Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga", date);
    }
}

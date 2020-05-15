package Test;

import BaseDatos.CasinoBarcelona;

public class TestCasinoBarcelona {
    public static void main(String[] args) {
        CasinoBarcelona casinoBarcelona = new CasinoBarcelona();
        casinoBarcelona.parseadorBarcelona("CasinoBarcelona","Bundesliga", "https://apuestas.casinobarcelona.es/competicion/268-bundesliga");
    }
}

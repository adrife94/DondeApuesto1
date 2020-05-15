package Test;

import BaseDatos.GoldenPark;

public class TestGoldenPark {
    public static void main(String[] args) {
        GoldenPark gp = new GoldenPark();
        gp.parseadorGolden("GoldenPark","Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#");
    }
}

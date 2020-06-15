package Test;

import BaseDatos.GoldenPark;

import java.util.Date;

public class TestGoldenPark {
    public static void main(String[] args) {
        Date date = new Date();
        GoldenPark gp = new GoldenPark();
        gp.parseadorGolden("goldenpark","Bundesliga", "https://apuestas.goldenpark.es/es/competicion/268-bundesliga#", date);
    }
}

package Test;

import BaseDatos.Sportium;

import java.util.Date;

public class TestSportium {
    public static void main(String[] args) {
        Date date = new Date();
        Sportium sportium = new Sportium();
        sportium.parseadorSportium("sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga", date);
    }
}

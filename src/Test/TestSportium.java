package Test;

import BaseDatos.Sportium;

public class TestSportium {
    public static void main(String[] args) {
        Sportium sportium = new Sportium();
        sportium.parseadorSportium("Sportium","Bundesliga", "https://sports.sportium.es/es/t/45915/Bundesliga");
    }
}

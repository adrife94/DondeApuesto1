package Test;



import BaseDatos.Suertia;

import java.util.Date;

public class TestSuertia {
    public static void main(String[] args) {
        Date date = new Date();
        Suertia suertia = new Suertia();
        suertia.parseadorSuertia("suertia","Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga", date);
    }
}

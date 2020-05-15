package Test;

import BaseDatos.ModeloParaTodas;
import BaseDatos.Sissal;

public class TestSissal {
    public static void main(String[] args) {
        Sissal sissal = new Sissal();
        sissal.parseador ("Sissal","Bundesliga", "https://apuestas.sisal.es/es/competicion/268-bundesliga");
    }
}

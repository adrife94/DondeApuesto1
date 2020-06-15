package Test;

import BaseDatos.ModeloParaTodas;
import BaseDatos.Sissal;

import java.util.Date;

public class TestSissal {
    public static void main(String[] args) {
        Date date = new Date();
        Sissal sissal = new Sissal();
        sissal.parseador ("sissal","Bundesliga", "https://apuestas.sisal.es/es/competicion/268-bundesliga", date);
    }
}

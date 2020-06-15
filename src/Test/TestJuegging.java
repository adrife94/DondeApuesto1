package Test;

import BaseDatos.Juegging;

import java.util.Date;


public class TestJuegging {
    public static void main(String[] args) {
        Date date = new Date();
        Juegging juegging = new Juegging();
        juegging.parseador ("juegging","Bundesliga", "https://apuestas.juegging.es/esp/Sport/Competicion/351", date);
    }
}

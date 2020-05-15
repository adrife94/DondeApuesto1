package Test;

import BaseDatos.Juegging;


public class TestJuegging {
    public static void main(String[] args) {
        Juegging juegging = new Juegging();
        juegging.parseador ("Juegging","Bundesliga", "https://apuestas.juegging.es/esp/Sport/Competicion/351");
    }
}

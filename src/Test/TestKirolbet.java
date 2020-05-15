package Test;

import BaseDatos.Kirolbet;

public class TestKirolbet {
    public static void main(String[] args) {
        Kirolbet exclusivebet = new Kirolbet();
        exclusivebet.parseador ("Kirolbet","Bundesliga", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351");
    }
}

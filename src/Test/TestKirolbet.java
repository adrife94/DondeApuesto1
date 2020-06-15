package Test;

import BaseDatos.Kirolbet;

import java.util.Date;

public class TestKirolbet {
    public static void main(String[] args) {
        Date date = new Date();
        Kirolbet kirolbet = new Kirolbet();
        kirolbet.parseador ("kirolbet","Bundesliga", "https://apuestas.kirolbet.es/esp/Sport/Competicion/351", date);
    }
}

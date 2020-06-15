package Test;

import BaseDatos.Interwetten;

import java.util.Date;

public class TestInterwetten {
    public static void main(String[] args) {
        Date date = new Date();
        Interwetten interwetten = new Interwetten();
        interwetten.parseadorInterwetten("interwetten","Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional", date);
    }
}

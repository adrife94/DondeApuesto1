package Test;

import BaseDatos.Interwetten;

public class TestInterwetten {
    public static void main(String[] args) {
        Interwetten interwetten = new Interwetten();
        interwetten.parseadorInterwetten("Interwetten","Bundesliga", "https://www.interwetten.es/es/apuestas-deportivas/l/1019/alemania-liga-nacional");
    }
}

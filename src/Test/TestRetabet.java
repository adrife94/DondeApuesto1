package Test;

import BaseDatos.Retabet;

public class TestRetabet {
    public static void main(String[] args) {
        Retabet retabet = new Retabet();
        retabet.parseador ("Retabet","Bundesliga", "https://apuestas.retabet.es/deportes");
    }
}

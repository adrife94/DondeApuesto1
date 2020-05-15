package Test;

import BaseDatos.MarcaApuestas;

public class TestMarcaApuestas {
    public static void main(String[] args) {
        MarcaApuestas marcaApuestas = new MarcaApuestas();
        marcaApuestas.parseadorMarca("MarcaApuestas","Bundesliga", "https://deportes.marcaapuestas.es/es/t/19158/Bundesliga-1-En-directo-en-MARCA-Apuestas-TV");
    }
}

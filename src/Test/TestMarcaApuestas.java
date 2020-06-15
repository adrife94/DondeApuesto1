package Test;

import BaseDatos.MarcaApuestas;

import java.util.Date;

public class TestMarcaApuestas {
    public static void main(String[] args) {
        Date date = new Date();
        MarcaApuestas marcaApuestas = new MarcaApuestas();
        marcaApuestas.parseadorMarca("marcaapuestas","LaLiga", "https://deportes.marcaapuestas.es/es/t/19160/LaLiga-Santander", date);
    }
}

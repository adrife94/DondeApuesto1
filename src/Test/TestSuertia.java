package Test;



import BaseDatos.Suertia;

public class TestSuertia {
    public static void main(String[] args) {
        Suertia suertia = new Suertia();
        suertia.parseadorSuertia("Suertia","Bundesliga", "https://apuestas.suertia.es/competicion/268-bundesliga");
    }
}

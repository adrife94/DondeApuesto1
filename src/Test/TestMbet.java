package Test;


import BaseDatos.Mbet;

public class TestMbet {
    public static void main(String[] args) {
        Mbet mbet = new Mbet();
        mbet.parseadorMbet("Mbet","Bundesliga", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436");
    }
}

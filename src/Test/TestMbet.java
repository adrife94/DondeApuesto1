package Test;


import BaseDatos.Mbet;

import java.util.Date;

public class TestMbet {
    public static void main(String[] args) {
        Date date = new Date();
        Mbet mbet = new Mbet();
        mbet.parseadorMbet("mbet","Bundesliga", "https://www.marathonbet.es/es/popular/Football/Germany/Bundesliga+-+22436", date);
    }
}

package Test;

import BaseDatos.Betfair;

import java.util.Date;

public class TestBetfair {

    public static void main(String[] args) {
        Date date = new Date();
        Betfair betfair = new Betfair();
        betfair.parseadorBetfair("betfair","Bundesliga", "https://www.betfair.es/sport/football?id=59&competitionEventId=605621&action=loadCompetition&modules=multipickavbId@1006&selectedTabType=COMPETITION", date);
    }
}

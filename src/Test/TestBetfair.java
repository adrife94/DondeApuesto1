package Test;

import BaseDatos.Betfair;

public class TestBetfair {

    public static void main(String[] args) {
        Betfair betfair = new Betfair();
        betfair.parseadorBetfair("Betfair","Bundesliga", "https://www.betfair.es/sport/football?id=59&competitionEventId=605621&action=loadCompetition&modules=multipickavbId@1006&selectedTabType=COMPETITION");
    }
}

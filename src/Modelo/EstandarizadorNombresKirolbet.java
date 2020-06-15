package Modelo;

public class EstandarizadorNombresKirolbet {
    public static String estandarizadorEquiposLaLiga(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "Athletic Club":
                equipomodificado = "Athletic";
                break;
            case "RC Celta":
                equipomodificado = "Celta";
                break;
            case "Celta de Vigo":
                equipomodificado = "Celta";
                break;
            case "Valencia CF":
                equipomodificado = "Valencia";
                break;
            case "SD Eibar":
                equipomodificado = "Eibar";
                break;
            case "CD Leganés":
                equipomodificado = "Leganes";
                break;
            case "Leganés":
                equipomodificado = "Leganes";
                break;
            case "D.Alavés":
                equipomodificado = "Alaves";
                break;
            case "CD Alavés":
                equipomodificado = "Alaves";
                break;
            case "Villarreal CF":
                equipomodificado = "Villarreal";
                break;
            case "Levante UD":
                equipomodificado = "Levante";
                break;
            case "RCD Espanyol":
                equipomodificado = "Espanyol";
                break;
            case "Sevilla FC":
                equipomodificado = "Sevilla";
                break;
            case "Real Valladolid":
                equipomodificado = "Valladolid";
                break;
            case "Atlético de Madrid":
                equipomodificado = "Atletico Madrid";
                break;
            case "Getafe CF":
                equipomodificado = "Getafe";
                break;
            case "Granada CF":
                equipomodificado = "Granada";
                break;
        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposBundesliga(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "Borussia Dortmund":
                equipomodificado = "Dortmund";
                break;
            case "Schalke 04":
                equipomodificado = "Schalke";
                break;
            case "Hoffenheim":
                equipomodificado = "Hoffenheim";
                break;
            case "Hertha BSC":
                equipomodificado = "Hertha Berlin";
                break;
            case "Augsburg":
                equipomodificado = "Ausburgo";
                break;
            case "Wolfsburg":
                equipomodificado = "Wolfsburgo";
                break;
            case "Fortuna Dusseldorf":
                equipomodificado = "Fortuna";
                break;
            case "Paderborn":
                equipomodificado = "Paderborn";
                break;
            case "RB Leipzig":
                equipomodificado = "Leipzig";
                break;
            case "SC Freiburg":
                equipomodificado = "Friburgo";
                break;
            case "Frankfurt":
                equipomodificado = "Frankfurt";
                break;
            case "Borussia M'gladbach":
                equipomodificado = "Monchengladbach";
                break;
            case "Colonia":
                equipomodificado = "Colonia";
                break;
            case "FSV Mainz 05":
                equipomodificado = "Mainz";
                break;
            case "FC Unión Berlín":
                equipomodificado = "Union Berlin";
                break;
            case "Bayern Múnich":
                equipomodificado = "Bayern";
                break;
            case "Werder Bremen":
                equipomodificado = "Werder Bremen";
                break;
            case "Bayer Leverkussen":
                equipomodificado = "Leverkusen";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposCalcio(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "SSC Napoli":
                equipomodificado = "Napoles";
                break;
            case "Bologna":
                equipomodificado = "Bolonia";
                break;
            case "AC Milán":
                equipomodificado = "Milan";
                break;
            case "Genoa":
                equipomodificado = "Genova";
                break;
            case "Parma Calcio 1913":
                equipomodificado = "Parma";
                break;
            case "FC Torino":
                equipomodificado = "Torino";
                break;
            case "FC Parma":
                equipomodificado = "Parma";
                break;
            case "Hellas Verona":
                equipomodificado = "Verona";
                break;
            case "Atalanta Bergamo":
                equipomodificado = "Atalanta";
                break;
            case "US Sassuolo":
                equipomodificado = "Sassuolo";
                break;
            case "Inter de Milán":
                equipomodificado = "Inter";
                break;
            case "UC Sampdoria":
                equipomodificado = "Sampdoria";
                break;
            case "Brescia Calcio":
                equipomodificado = "Brescia";
                break;
            case "AC Fiorentina":
                equipomodificado = "Fiorentina";
                break;
            case "US Lecce":
                equipomodificado = "Lecce";
                break;
            case "FC Bologna":
                equipomodificado = "Bolonia";
                break;
            case "Juventus de Turín":
                equipomodificado = "Juventus";
                break;
            case "Spal 2013":
                equipomodificado = "Spal";
                break;
            case "Udinese Calcio":
                equipomodificado = "Udinese";
                break;
            case "Genoa CFC":
                equipomodificado = "Genova";
                break;
            case "AS Roma":
                equipomodificado = "Roma";
                break;
            case "SS Lazio":
                equipomodificado = "Lazio";
                break;

            case "SSC Nápoles":
                equipomodificado = "Napoles";
                break;
            case "Génova":
                equipomodificado = "Genova";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposPremier(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "Sheffield Utd":
                equipomodificado = "Sheffield";
                break;
            case "Manchester City":
                equipomodificado = "Man City";
                break;
            case "Manchester United":
                equipomodificado = "Man United";
                break;
            case "FC Arsenal":
                equipomodificado = "Arsenal";
                break;
            case "Norwich City":
                equipomodificado = "Norwich";
                break;
            case "Southampton FC":
                equipomodificado = "Southampton";
                break;
            case "Tottenham Hotspur":
                equipomodificado = "Tottenham";
                break;
            case "FC Watford":
                equipomodificado = "Watford";
                break;
            case "Leicester City":
                equipomodificado = "Leicester";
                break;
            case "FC Brighton & Hove Albion":
                equipomodificado = "Brighton";
                break;
            case "West Ham United":
                equipomodificado = "West Ham";
                break;
            case "Wolverhampton Wanderers":
                equipomodificado = "Wolves";
                break;
            case "AFC Bournemouth":
                equipomodificado = "Bournemouth";
                break;
            case "Newcastle United":
                equipomodificado = "Newcastle";
                break;
            case "Chelsea FC":
                equipomodificado = "Chelsea";
                break;
            case "FC Everton":
                equipomodificado = "Everton";
                break;
            case "FC Liverpool":
                equipomodificado = "Liverpool";
                break;
            case "FC Burnley":
                equipomodificado = "Burnley";
                break;
        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposEredivise(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "ADO Den Haag":
                equipomodificado = "Den Hagg";
                break;
            case "Fortuna Sittard":
                equipomodificado = "Fortuna";
                break;
            case "Willem II Tilburg":
                equipomodificado = "Willem II";
                break;
            case "Heracles Almelo":
                equipomodificado = "Heracles";
                break;
            case "Sparta Rotterdam":
                equipomodificado = "Sparta";
                break;
            case "FC Twente":
                equipomodificado = "Twente";
                break;
            case "RKC Waalwijk":
                equipomodificado = "Waalwijk";
                break;
            case "VVV Venlo":
                equipomodificado = "Venlo";
                break;
            case "AZ Alkmaar":
                equipomodificado = "Alkmaar";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposLigue1(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "Girondins de Burdeos":
                equipomodificado = "Burdeos";
                break;
            case "St Etienne":
                equipomodificado = "Etienne";
                break;
        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposPrimeira(String equipos){

        String equipomodificado = equipos;


        return equipomodificado;
    }
}

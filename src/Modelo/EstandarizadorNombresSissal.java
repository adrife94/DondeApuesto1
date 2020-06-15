package Modelo;

public class EstandarizadorNombresSissal {
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
            case "Alavés":
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
            case "Real Betis":
                equipomodificado = "Betis";
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
            case "Hertha Berlín":
                equipomodificado = "Hertha Berlin";
                break;
            case "Augsburgo":
                equipomodificado = "Ausburgo";
                break;
            case "Wolfsburgo":
                equipomodificado = "Wolfsburgo";
                break;
            case "Fortuna Düsseldorf":
                equipomodificado = "Fortuna";
                break;
            case "SC Paderborn 07":
                equipomodificado = "Paderborn";
                break;
            case "RB Leipzig":
                equipomodificado = "Leipzig";
                break;
            case "Friburgo":
                equipomodificado = "Friburgo";
                break;
            case "Eintracht Frankfurt":
                equipomodificado = "Frankfurt";
                break;
            case "Eintracht Francfort":
                equipomodificado = "Frankfurt";
                break;
            case "Borussia Mönchengladbach":
                equipomodificado = "Monchengladbach";
                break;
            case "Colonia":
                equipomodificado = "Colonia";
                break;
            case "Mainz":
                equipomodificado = "Mainz";
                break;
            case "Unión Berlín":
                equipomodificado = "Union Berlin";
                break;
            case "Bayern Múnich":
                equipomodificado = "Bayern";
                break;
            case "Werder Bremen":
                equipomodificado = "Werder Bremen";
                break;
            case "Bayer Leverkusen":
                equipomodificado = "Leverkusen";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposCalcio(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "Nápoles":
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
            case "Génova CFC":
                equipomodificado = "Genova";
                break;
            case "Parma FC":
                equipomodificado = "Parma";
                break;
            case "Torino FC":
                equipomodificado = "Torino";
                break;
            case "Hellas Verona":
                equipomodificado = "Verona";
                break;
            case "AS Roma":
                equipomodificado = "Roma";
                break;
            case "Inter de Milán":
                equipomodificado = "Inter";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposPremier(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "Sheffield United":
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
            case "Watford FC":
                equipomodificado = "Watford";
                break;
            case "Leicester City":
                equipomodificado = "Leicester";
                break;
            case "Brighton & Hove Albion":
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
            case "Burnley FC":
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

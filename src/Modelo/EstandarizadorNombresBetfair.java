package Modelo;

public class EstandarizadorNombresBetfair {
    public static String estandarizadorEquiposLaLiga(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "Athletic Club":
                equipomodificado = "Athletic";
                break;
            case "Athletic de Bilbao":
                equipomodificado = "Athletic";
                break;
            case "Mallorca":
                equipomodificado = "Mallorca";
                break;
            case "Betis":
                equipomodificado = "Betis";
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
                equipomodificado = "Leganés";
                break;
            case "D.Alavés":
                equipomodificado = "Alaves";
                break;
            case "Alavés":
                equipomodificado = "Alaves";
                break;
            case "Villarreal CF":
                equipomodificado = "Villarreal";
                break;
            case "Villarreal":
                equipomodificado = "Villarreal";
                break;
            case "Levante UD":
                equipomodificado = "Levante";
                break;
            case "RCD Espanyol":
                equipomodificado = "Espanyol";
                break;
            case "Espanyol":
                equipomodificado = "Espanyol";
                break;
            case "Leganés":
                equipomodificado = "Leganes";
                break;
            case "Sevilla FC":
                equipomodificado = "Sevilla";
                break;
            case "Sevilla":
                equipomodificado = "Sevilla";
                break;
            case "Real Valladolid":
                equipomodificado = "Valladolid";
                break;
            case "Atlético Madrid":
                equipomodificado = "Atletico Madrid";
                break;
            case "Atlético de Madrid":
                equipomodificado = "Atletico Madrid";
                break;
            case "Getafe CF":
                equipomodificado = "Getafe";
                break;
            case "FC Barcelona":
                equipomodificado = "Barcelona";
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
            case "Fortuna Dusseldorf":
                equipomodificado = "Fortuna";
                break;
            case "Paderborn":
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
            case "B Mönchengladbach":
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
            case "Leverkusen":
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
            case "AC Milan":
                equipomodificado = "Milan";
                break;
            case "Genoa":
                equipomodificado = "Genova";
                break;
            case "Génova":
                equipomodificado = "Genova";
                break;
            case "Parma Calcio 1913":
                equipomodificado = "Parma";
                break;
            case "Inter de Milán":
                equipomodificado = "Inter";
                break;
            case "AC Milán":
                equipomodificado = "Milan";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposPremier(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "Sheffield":
                equipomodificado = "Sheffield";
                break;
            case "Sheffield United":
                equipomodificado = "Sheffield";
                break;
            case "Newcastle":
                equipomodificado = "Newcastle";
                break;
            case "Manchester City":
                equipomodificado = "Man City";
                break;
            case "Manchester United":
                equipomodificado = "Man United";
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

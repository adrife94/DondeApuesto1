package Modelo;

public class EstandarizadorNombresRetabet {
    public static String estandarizadorEquiposLaLiga(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "Athletic Club":
                equipomodificado = "Athletic";
                break;
            case "RC Celta":
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
            case "Atlético Madrid":
                equipomodificado = "Atletico Madrid";
                break;
            case "Getafe CF":
                equipomodificado = "Getafe";
                break;
        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposBundesliga(String equipos){

        String equipomodificado = equipos;

        switch (equipos) {
            case "BORUSSIA DORTMUND":
                equipomodificado = "Dortmund";
                break;
            case "SCHALKE 04":
                equipomodificado = "Schalke";
                break;
            case "HOFFENHEIM":
                equipomodificado = "Hoffenheim";
                break;
            case "HERTHA BERLIN":
                equipomodificado = "Hertha Berlin";
                break;
            case "AUGSBURG":
                equipomodificado = "Ausburgo";
                break;
            case "WOLFSBURGO":
                equipomodificado = "Wolfsburgo";
                break;
            case "FORTUNA DUSSELDORF":
                equipomodificado = "Fortuna";
                break;
            case "PADERBORN":
                equipomodificado = "Paderborn";
                break;
            case "LEIPZIG":
                equipomodificado = "Leipzig";
                break;
            case "FRIBURGO":
                equipomodificado = "Friburgo";
                break;
            case "EINTRACHT FRANKFURT":
                equipomodificado = "Frankfurt";
                break;
            case "B. MONCHENGLADBACH":
                equipomodificado = "Monchengladbach";
                break;
            case "COLONIA":
                equipomodificado = "Colonia";
                break;
            case "MAINZ":
                equipomodificado = "Mainz";
                break;
            case "UNION BERLIN":
                equipomodificado = "Union Berlin";
                break;
            case "BAYERN MUNICH":
                equipomodificado = "Bayern";
                break;
            case "WERDER BREMEN":
                equipomodificado = "Werder Bremen";
                break;
            case "BAYER LEVERKUSEN":
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
            case "AC Milan":
                equipomodificado = "Milan";
                break;
            case "Genoa":
                equipomodificado = "Genova";
                break;
            case "Parma Calcio 1913":
                equipomodificado = "Parma";
                break;

        }

        return equipomodificado;
    }

    public static String estandarizadorEquiposPremier(String equipos){

        String equipomodificado = equipos;


        switch (equipos) {
            case "Sheff Utd":
                equipomodificado = "Sheffield";
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

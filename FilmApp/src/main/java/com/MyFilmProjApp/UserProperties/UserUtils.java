package com.MyFilmProjApp.UserProperties;

public class UserUtils {

    public enum AgeInterval{
        Under_18,
        A_18_24,
        A_25_34,
        A_35_44,
        A_45_49,
        A_50_55,
        A_56P;
    }

    public enum Occupation{
        OTHER,
        ACADEMIC_EDUCATOR,
        ARTIST,
        CLERICAL_ADMIN,
        COLLEGE_GRADSTUDENT,
        CUSTOMER_SERVICE,
        DOCTOR_HEALTHCARE,
        EXECUTIVE_MANAGERIAL,
        FARMER,
        HOMEMAKER,
        K_12_STUDENT,
        LAWYER,
        PROGRAMMER,
        RETIRED,
        SALES_MARKETING,
        SCIENTIST,
        SELF_EMPLOYED,
        TECHNICIAN_ENGINEER,
        TRADESMAN_CRAFTSMAN,
        UNEMPLOYED,
        WRITER;
    }

    public enum Gender{
        Man, Woman;
    }

    /**
     * retourne catégorie âge en String
     * @param age constante tranche d'âge
     * @return String age associé à constante
     */
    public static String getAgeToString(AgeInterval age){
        switch(age) {
            case Under_18:
                return "Under 18";
            case A_18_24:
                return  "18-24";
            case A_25_34:
                return  "25-34";
            case A_35_44:
                return  "35-34";
            case A_45_49:
                return  "45-49";
            case A_50_55:
                return  "50-55";
            case A_56P:
                return "56+";
            default:
                return null;
        }
    }

    /**
     * retourne catégorie Profession en String
     * @param occ constante type profession
     * @return String profession associé à constante
     */
    public static String getOccupToString(Occupation occ){
        switch(occ) {
            case OTHER:
                return "other";
            case ACADEMIC_EDUCATOR:
                return  "academic/educator";
            case ARTIST:
                return  "artist";
            case CLERICAL_ADMIN:
                return  "clerical/admin";
            case COLLEGE_GRADSTUDENT:
                return  "college/grad student";
            case CUSTOMER_SERVICE:
                return  "customer service";
            case DOCTOR_HEALTHCARE:
                return "doctor/health care";
            case EXECUTIVE_MANAGERIAL:
                return "executive/managerial";
            case FARMER:
                return "farmer";
            case HOMEMAKER:
                return "homemaker";
            case K_12_STUDENT:
                return "K-12 student";
            case LAWYER:
                return "lawyer";
            case PROGRAMMER:
                return "programmer";
            case RETIRED:
                return "retired";
            case SALES_MARKETING:
                return "sales/marketing";
            case SCIENTIST:
                return "scientist";
            case SELF_EMPLOYED:
                return "self-employed";
            case TECHNICIAN_ENGINEER:
                return "technician/engineer";
            case TRADESMAN_CRAFTSMAN:
                return "tradesman/craftsman";
            case UNEMPLOYED:
                return "unemployed";
            case WRITER:
                return "writer";

            default:
                return null;
        }
    }

    /**
     * retourne civilité en String
     * @param gender constante civilité
     * @return String civilité associé à constante
     */
    public static String getGenderToString(Gender gender){
        switch(gender) {
            case Man:
                return "Mr";
            case Woman:
                return  "Mme";
            default:
                return null;
        }
    }
}

package AddNewEntry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Maria Lykoudi
 */
public class Check {
    
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean checkIfInt(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (java.lang.NumberFormatException ex) {
            return false;
        }
    }

    public static boolean checkDate(String date) {
        try {
            LocalDate.parse(date, format);
            return true;
        } catch (java.time.format.DateTimeParseException ex) {
            return false;
        }
    }
}

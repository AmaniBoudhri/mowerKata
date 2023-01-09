package amani.fr.utils;

public class CheckLineUtils {
    public static boolean checkLineForLawnSize(String line) {
        return line.matches("^[0-9] [0-9]$");
    }

    public static boolean checkLineForPosition(String line) {
        return line.matches("^[0-9] [0-9] (N|S|E|W)$");
    }

    public static boolean checkLineForCommand(String line) {
        return line.matches("^[AGD]+$");
    }

}

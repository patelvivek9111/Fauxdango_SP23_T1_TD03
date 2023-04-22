package Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The ValidationHelper class provides utility methods to perform various validations such as parsing integers/doubles,
 * validating characters within a given range, validating if a string is "Y" or "N", checking if an integer is within a given range,
 * and checking if a string is null or empty.
 *
 * @author Ildar Sadykov
 * @author Vivek Patel
 */
public class ValidationHelper {
    /**
     * Attempts to parse a given string as a double.
     *
     * @param text the string to parse
     * @return the double value represented by the string, or null if the string cannot be parsed as a double
     */
    private final static Logger logger = LogManager.getRootLogger();

    public static Double tryParseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (Exception e) {
            logger.debug("Invalid input: " + text);
            return null;
        }
    }
    /**
     * Attempts to parse a given string as an integer.
     *
     * @param text the string to parse
     * @return the integer value represented by the string, or null if the string cannot be parsed as an integer
     */

    public static Integer tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            logger.debug("Invalid input: " + text);
            return null;
        }
    }

    /**
     * Determines whether a given character falls within a given range of valid characters.
     *
     * @param ch the character to validate
     * @param range the string holding the valid characters
     * @return true if the character is in range, false otherwise
     */
    public static boolean isCharInRange(char ch, String range) {
        if (range == null) {
            return false;
        }
        return (range.indexOf(ch) >= 0);
    }

    /**
     * Checks if a given string is "Y" or "N".
     *
     * @param str the string to check
     * @return true if the string is "Y" or "N", false otherwise
     */
    public static boolean isValidYorN(String str) {
        return ("N".equals(str) || "Y".equals(str));
    }
    /**
     * Determines whether a supplied integer falls within a given range.
     *
     * @param value the integer to validate
     * @param start the start of the valid range (inclusive)
     * @param end the end of the valid range (inclusive)
     * @return true if the integer is within the range, false otherwise
     */
    public static boolean isIntInRange(int value, int start, int end) {
        if (value < start || value > end) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Determines if a given string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty, false otherwise
     */
    public static boolean isStringNullOrEmpty(String str) {
        return ((str == null) || (str.isEmpty()));
    }

}

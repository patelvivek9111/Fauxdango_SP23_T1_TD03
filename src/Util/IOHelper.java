package Util;

import Model.Console;

import java.util.Scanner;

public class IOHelper {
    private static final Scanner keyboard = Console.keyboard;

    /**
     * Reads a string from the keyboard and prompts the user for input using a supplied prompt.
     *
     * @param prompt the prompt to be displayed to the user.
     * @return a string entered by the user.
     */
    public static String readStringFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");

        return keyboard.nextLine();
    }
    /**
     * Reads a non-blank string from the keyboard and prompts the user for input using a specified prompt.
     * The prompt is repeated until a non-blank string is entered.
     *
     * @param prompt the prompt to be displayed to the user.
     * @return a non-blank string entered by the user.
     */
    public static String readNonBlankStringFromKeyboard(String prompt) {
        String nonblankString;

        while (true) {
            nonblankString = readStringFromKeyboard(prompt);
            if (nonblankString.trim().isEmpty()) {
                System.out.println();
                System.out.println("Cannot be blank");
            } else {
                break;
            }
        }

        return nonblankString;
    }

    /**
     * Prompts the user to enter a valid double, utilizing a given prompt to solicit feedback from the user.
     * The prompt is repeated until a valid double is entered.
     *
     * @param prompt the prompt to be displayed to the user.
     * @return a double entered by the user.
     */
    public static double userInputDouble(String prompt) {
        Double parsedToDouble = null;

        while (parsedToDouble == null) {
            String userInput = readStringFromKeyboard(prompt);
            parsedToDouble = ValidationHelper.tryParseDouble(userInput);
        }

        return parsedToDouble;
    }

    /**
     * Prompts the user to enter a valid character, using a provided prompt and valid character range.
     * Repeats the prompt until a valid character within the range is entered.
     *
     * @param prompt the prompt to be displayed to the user.
     * @param range the valid characters allowed (packed into a string).
     * @return a character within the valid range entered by the user.
     */
    public static char userInputChar(String prompt, String range) {

        char userChar = 0;
        while (!ValidationHelper.isCharInRange(userChar, range)) {
            String userInput = readStringFromKeyboard(prompt + " (" + range + ")");
            if (userInput.length() > 0) {
                userChar = userInput.charAt(0);
            }
        }

        return userChar;
    }

}

package ca.ucalgary.ensf380;

import java.util.Scanner;

/**
 * <h1>DateNormalizer.java</h1>
 * <p>
 * This class is designed for normalizing date-like numbers in Java.
 * It is part of Lab 4 Exercise D.
 * </p>
 * <p>
 * <b>Note:</b> This file represents the solution for handling date normalization.
 * </p>
 * <p><b>Submission Date:</b> July 24, 2024</p>
 * 
 * @version 1.0
 * @version Hamza Imtiaz
 * @version Farha Ahmed
 */
public class DateNormalizer {

    /**
     * Custom exception class to handle invalid dates.
     */
    public static class InvalidDateException extends Exception {
        public InvalidDateException(String message) {
            super(message);
        }
    }

    /**
     * Normalizes a date-like number to the format yyyy-mm-dd.
     * 
     * @param input the date-like number as a string
     * @return the normalized date as a string, or an error message if the date is invalid
     */
    public static String normalizeDate(String input) {
        // Regular expression to match date-like patterns
        String regex = "(\\d{4})[-.](\\d{2})[-.](\\d{2})|(\\d{2})[-.](\\d{2})[-.](\\d{4})";
        if (!input.matches(regex)) {
            return "";
        }

        try {
            // Check if the input matches the yyyy-mm-dd format
            if (input.matches("\\d{4}[-.]\\d{2}[-.]\\d{2}")) {
                return normalizeYearMonthDay(input);
            } 
            // Check if the input matches the dd-mm-yyyy format
            else if (input.matches("\\d{2}[-.]\\d{2}[-.]\\d{4}")) {
                return normalizeDayMonthYear(input);
            } else {
                return "";
            }
        } catch (InvalidDateException e) {
            return e.getMessage();
        }
    }

    /**
     * Normalizes a date in the yyyy-mm-dd format.
     * 
     * @param input the date string
     * @return the normalized date string
     * @throws InvalidDateException if the date is invalid
     */
    private static String normalizeYearMonthDay(String input) throws InvalidDateException {
        String[] parts = input.split("[-.]");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        // Validate the date components
        validateDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        return String.format("%s-%s-%s", year, month, day);
    }

    /**
     * Normalizes a date in the dd-mm-yyyy format.
     * 
     * @param input the date string
     * @return the normalized date string
     * @throws InvalidDateException if the date is invalid
     */
    private static String normalizeDayMonthYear(String input) throws InvalidDateException {
        String[] parts = input.split("[-.]");
        String day = parts[0];
        String month = parts[1];
        String year = parts[2];

        // Validate the date components
        validateDate(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        return String.format("%s-%s-%s", year, month, day);
    }

    /**
     * Validates the date components to ensure they represent a valid date.
     * 
     * @param year the year component of the date
     * @param month the month component of the date
     * @param day the day component of the date
     * @throws InvalidDateException if the date components are invalid
     */
    private static void validateDate(int year, int month, int day) throws InvalidDateException {
        if (month < 1 || month > 12) {
            throw new InvalidDateException("Not a valid month");
        }
        if (day < 1 || day > 31) {
            throw new InvalidDateException("Not a valid day");
        }
        // Additional checks for days in month can be added here if necessary
    }

    /**
     * Main method to execute the date normalization program.
     * Continuously prompts the user for input and normalizes the provided date-like numbers.
     * Exits when the user chooses not to continue.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            // Prompt the user to enter a date-like number
            System.out.print("Enter a date-like number: ");
            String input = scanner.nextLine();
            String output = normalizeDate(input);
            // Display the normalized date or an error message
            System.out.println("Normalized Date: " + output);

            // Ask the user if they would like to continue
            System.out.print("Would you like to continue? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            // Continue or exit based on the user's response
            continueInput = response.equals("yes");
        }

        scanner.close();
        System.out.println("Program exited.");
    }
}



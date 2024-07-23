/**
 * <h1>SimpleArrays.java</h1>
 * <p>
 * This class is designed for processing arrays in Java.
 * It is part of Lab 4 Exercise B.
 * </p>
 * <p>
 * <b>Note:</b> This file represents the solution for handling arrays.
 * </p>
 * <p><b>Submission Date:</b> July 24, 2024</p>
 * @author Hamza Imtiaz
 * @author Farha Ahmed
 */
package ca.ucalgary.ensf380;

public class SimpleArrays {
    private String[] array;

    /**
     * Constructor that initializes the array with a specified string.
     * 
     * @param str the string to fill the array with.
     */
    public SimpleArrays(String str) {
        array = new String[4];
        java.util.Arrays.fill(array, str);
    }

    /**
     * Default constructor that initializes the array with "Hello, ENSF 380".
     */
    public SimpleArrays() {
        this("Hello, ENSF 380");
    }

    /**
     * Concatenates the elements of the array starting from a specified index.
     * 
     * @param index the starting index.
     * @return a string with array elements concatenated, separated by '#'.
     */
    public String arrayConcat(int index) {
        // Ensure the index is within bounds, default to 0 if out of bounds
        if (index < 0 || index >= array.length) {
            index = 0;
        }

        StringBuilder result = new StringBuilder();
        for (int i = index; i < array.length; i++) {
            if (i > index) {
                result.append("#");
            }
            result.append(array[i]);
        }
        return result.toString();
    }

    /**
     * Overloaded method that concatenates the array elements from index 0.
     * 
     * @return a string with array elements concatenated, separated by '#'.
     */
    public String arrayConcat() {
        return arrayConcat(0);
    }

    /**
     * Returns a concatenated string of array elements between two indices.
     * 
     * @param start the starting index.
     * @param end the ending index (inclusive).
     * @return a string with array elements concatenated, or "Fail" if indices are invalid, or "Match" if indices are the same.
     */
    public String arrayCrop(int start, int end) {
        // Validate indices
        if (start < 0 || end < 0 || start >= array.length || end >= array.length) {
            return "Fail";
        }

        // Check if start and end are the same
        if (start == end) {
            return "Match";
        }

        // Swap indices if start is greater than end
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i > start) {
                result.append("#");
            }
            result.append(array[i]);
        }
        return result.toString();
    }
}

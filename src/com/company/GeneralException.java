package com.company;
/**
 * This is a class for a general exception to using the program
 */
public class GeneralException extends Exception {
    /**
     * This is the class builder function
     * @param msg
     */
    public GeneralException(String msg) {
        super(msg);
    }
}

package com.company;

/**
 * This interface for the various commands
 */
public interface command {
    /**
     * This function checks if an abnormality occurred during the test
     * @return true if the command's checking success
     * @throws GeneralException if an abnormality occurred during the test
     */
    boolean checkingContentType() throws GeneralException;
}

package com.company;

import java.io.IOException;

/**
 * This is a class for the Type command
 */
public class Type implements command {
    /**
     * This is the class constructor function
     * @param str is array of string that contain the command's part
     * @throws GeneralException if the command is invalid
     */
    public Type(String[] str) throws GeneralException {
        myStr = str;
        if(myStr.length < 2 || myStr.length > 3)
            throw new GeneralException("invalid command");
        try {
            myUrl = new Url(str[1]);
        }
        catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    /**
     * This function checks if the words of the file appear in the contents of the url
     * @return true if the field of the words of the file appear in the contents of the url
     * @throws GeneralException if there are URL problems or problems opening / reading / closing the file
     */
    public boolean checkingContentType() throws GeneralException {

        if(myStr.length < 3)
            return false;
        String type;
        try {
            type = myUrl.getType();
        } catch (IOException e) {
            throw new GeneralException("error");
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
        return type.contains(myStr[2]);
    }

    /**
     * A string of command line strings
     */
    private final String[] myStr;
    /**
     * An object from the URL class that handles URL-related operations
     */
    private final Url myUrl;
}

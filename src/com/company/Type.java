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
     * This function checking if the words of the file appear in the contents of the url
     * @return true if the field of the words of the file appear in the contents of the url
     * @throws GeneralException if If there are URL problems or problems opening / reading / closing the file
     */
    public boolean checkingContentType() throws GeneralException {

        if(myStr.length < 3)
            return false;
        try {
            cont = myUrl.getType();
        }
        catch (GeneralException e) {
            throw new GeneralException("bad url");
        }
        catch (IOException e) {
            throw new GeneralException("error");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cont.contains(myStr[2]);
    }

    private final String[] myStr;
    private final Url myUrl;
    private String cont;
}

package com.company;
/**
 * This is a class for the Type command
 */
public class Type implements command {
    /**
     * This is the class builder function
     * @param str
     * @throws GeneralException
     */
    public Type(String[] str) throws GeneralException {
        myStr = str;
        /**
         * This is a test of whether the URL argument is missing, and if so, an exception is thrown
         */
        if(myStr.length < 2)
            throw new GeneralException("bad Url");
        try {
            myUrl = new Url(str[1]);
        }
        catch (Exception e) {
            //System.out.println(e.getClass());
            throw new GeneralException(e.getMessage());
        }
    }

    /**
     *
     * @return Boolean value
     */
    public boolean checkingContentType() {

        if(myStr.length < 3)
            return false;
        try {
            cont = myUrl.getType();
        }
        catch (GeneralException e) {
            System.err.println("bad URL");
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

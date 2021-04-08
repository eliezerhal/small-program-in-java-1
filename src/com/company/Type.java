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
        try {
            myUrl = new Url(str[1]);
        }
        catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    /**
     *
     * @return Boolean value
     */
    public boolean checkingContentType() {

        try {
            String cont = myUrl.getType();
            if(cont.contains(myStr[2]))
                return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    private final String[] myStr;
    private final Url myUrl;
}

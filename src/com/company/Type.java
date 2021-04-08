package com.company;

public class Type implements command {
    public Type(String[] str) throws GeneralException {
        myStr = str;
        try {
            myUrl = new Url(str[1]);
        }
        catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

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

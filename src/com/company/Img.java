package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * This is a class for the Img command
 */
public class Img implements command {
    /**
     * This is the class constructor function
     * @param str is array of string that contain the command's part
     */
    public Img(String[] str) {
        myStr = str;
    }

    /**
     *
     * @return
     * @throws GeneralException
     */
    public boolean checkingContentType() throws GeneralException {
        if(myStr.length != 2)
            throw new GeneralException("invalid command");
        try {
            Document doc = Jsoup.connect(myStr[1]).get();
            Elements imageElements = doc.select("img");
            if (imageElements == null)
                return false;
        }
        catch (IOException e) {
            throw new GeneralException("error");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return true;
    }
    private final String[] myStr;
}
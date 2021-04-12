package com.company;

import java.net.*;
import java.net.URLConnection;

/**
 * This is a class for URL options
 */
public class Url {
    /**
     * This is the class constructor function
     * @param address is the web address in the commands
     */
    public Url(String address) {
        webAddress = address;
    }

    /**
     * This function returns ContentType of the URL
     * @return ContentType of the URL
     * @throws Exception if there are URL problems
     */
    public String getType() throws Exception {
        URL webAdr;
        try {
            webAdr = new URL(webAddress);
        }
        catch (IllegalArgumentException | MalformedURLException e) {
            throw new GeneralException("bad url");
        }
        URLConnection connection = webAdr.openConnection();
        return connection.getContentType();
    }

    private final String webAddress;
}

package com.company;

import java.net.*;
import java.net.URLConnection;

/**
 * This is a class for URL options
 */
public class Url {
    /***
     * This is the class constructor function
     * @param address is the web address in the commands
     */
    public Url(String address) {
        webAddress = address;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public String getType() throws Exception {
        URL webAdr;
        try {
            webAdr = new URL(webAddress);
        }
        catch (MalformedURLException e) {
            throw new GeneralException("bad url");
        }
        URLConnection connection = webAdr.openConnection();
        return connection.getContentType();
    }

    private final String webAddress;
}

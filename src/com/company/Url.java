package com.company;

import java.net.*;
import java.net.URLConnection;

public class Url {
    public Url(String address) {
        webAddress = address;
    }

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

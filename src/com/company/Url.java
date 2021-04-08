package com.company;

import java.net.*;
import java.net.URLConnection;

public class Url {
    public Url(String address) {
        webAddress = address;
    };
    public String getType() throws Exception{
        URL webAdr = new URL(webAddress);
        URLConnection connection = webAdr.openConnection();
        String content = connection.getContentType();
        return content;
    };
    private String webAddress;
}

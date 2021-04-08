package com.company;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Img implements command {
    public Img(String[] str) {
        myStr = str;
    }
    public boolean checkingContentType() {
        try {
            Document doc = Jsoup.connect(myStr[1]).get();
            Elements imageElements = doc.select("img");
            if (imageElements == null)
                return false;
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
    private String[] myStr;
}
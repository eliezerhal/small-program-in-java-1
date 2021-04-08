package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Language implements command {
    public Language(String[] str) {
        myStr = str;
    }
    public boolean checkingContentType() {
        if(isEnglish())
            return true;
        return false;
    }

    public boolean isEnglish() {
        int[] letteresArr = new int[27];
        try {
            String str = readText();
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    letteresArr[str.charAt(i) - 'a']++;
                }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
    public String readText() throws IOException {
        Document doc = Jsoup.connect(myStr[1]).get();
        String str = doc.text();
        str = str.toLowerCase();
        return str;
    }
    private String[] myStr;
}

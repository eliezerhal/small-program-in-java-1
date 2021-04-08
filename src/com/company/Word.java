package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Word implements command {
    public Word(String[] str) {
        myStr = str;
    }
    public boolean checkingContentType() {
        try {
            String[] words = readFile();
            if(words.length == 0)
                return true;
            Document doc = Jsoup.connect(myStr[1]).get();
            String str = doc.text();
            str = str.toLowerCase();
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
                if (!str.contains(words[i]))
                    return false;
            }
            return true;
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return true;
    }
    public String[] readFile() throws IOException {
        String str = "";
        String[] words = null;
        BufferedReader reader = new BufferedReader(new FileReader(myStr[2]));
        String line;
        try {
            while ((line = reader.readLine()) != null)
                str += line + " ";
            words = str.split(" ");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return words;
    }
    private String[] myStr;
}

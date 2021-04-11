package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This class that working on a "word" command
 */
public class Word implements command {
    /**
     * This is the class constructor function
     * @param str is array of string that contain the command's part
     */
    public Word(String[] str) {
        myStr = str;
    }

    /**
     * This function checking if the content type starts with a given string
     * @return true if the content type starts with a given string
     */
    public boolean checkingContentType() {
        try {
            if(myStr.length < 2 || myStr.length > 3)
                throw new GeneralException("invalid command");
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
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    /**
     * This function reads from the file
     * @return array of strings of the words in the file
     */
    public String[] readFile() {
        StringBuilder str = new StringBuilder();
        String[] words = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(myStr[2]))) {
            String line;
            while ((line = reader.readLine()) != null)
                str.append(line).append(" ");
            words = str.toString().split(" ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return words;
    }
    private final String[] myStr;
}

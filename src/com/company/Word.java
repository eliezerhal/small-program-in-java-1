package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class that working on a "word" command
 */
public class Word implements command {
    /**
     * This is the class constructor function
     * @param str is array of string that contain the command's part
     */
    public Word(String[] str) throws GeneralException{
        myStr = str;
        if(myStr.length < 2 || myStr.length > 3)
            throw new GeneralException("invalid command");
        try {
            myUrl = new Url(str[1]);
        }
        catch(Exception e){
            throw new GeneralException(e.getMessage());
        }
    }

    /**
     * This function checks if the content type starts with a given string
     * @return true if the content type starts with a given string
     */
    public boolean checkingContentType() throws GeneralException {
        try {
            String[] words = readFile();
            if(words.length == 0)
                return true;
            String type = myUrl.getType();
            if(!type.equals("text"))
                return false;
            Document doc = Jsoup.connect(myStr[1]).get();
            String str = doc.text();
            str = str.toLowerCase();
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
                if (!str.contains(words[i]))
                    return false;
            }
        }
        catch (IllegalArgumentException e) {
            throw new GeneralException("bad url");
        }
        catch (IOException e) {
            throw new GeneralException("error");
        }
        catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
        return true;
    }

    /**
     * This function reads from the file
     * @return array of strings of the words in the file
     */
    public String[] readFile() throws GeneralException {
        StringBuilder str = new StringBuilder();
        String[] words;
        try (BufferedReader reader = new BufferedReader(new FileReader(myStr[2]))) {
            String line;
            while ((line = reader.readLine()) != null)
                str.append(line).append(" ");
            words = str.toString().split(" ");
        } catch (Exception e) {
            throw new GeneralException("error");
        }
        return words;
    }
    /**
     * A string of command line strings
     */
    private final String[] myStr;
    /**
     * An object from the URL class that handles URL-related operations
     */
    private final Url myUrl;
}

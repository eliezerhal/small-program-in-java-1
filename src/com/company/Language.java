package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * This is a class for the Language command
 */
public class Language implements command {
    public Language(String[] str) {
        myStr = str;
        lettersArr = new int[26];
        counter = 0;
    }

    /**
     * this function checking if this is the desired language
     * @return true if this is the desired language
     * @throws GeneralException if the command is invalid
     */
    public boolean checkingContentType() throws GeneralException {
        if(myStr.length < 2 || myStr.length > 3)
            throw new GeneralException("invalid command");
        if(myStr.length != 3)
            return false;
        try {
            if (myStr[2].equals("english"))
                return isEnglish();
        }
        catch (IllegalArgumentException e) {
            throw new GeneralException("bad url");
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
        return false;
    }

    /**
     * this function checks if this is the desired language
     * @return true if the language is English
     * @throws GeneralException if there are URL problems or problems opening / reading / closing the file
     */
    public boolean isEnglish() throws GeneralException {
        try {
            counteringLetters();
            double[] frqArr = new double[26];
            double[] FrqArr = {0.0748, 0.0134, 0.0411, 0.0308, 0.1282, 0.0240,
                    0.0185, 0.0414, 0.0725, 0.0014, 0.0053, 0.0403, 0.0340,
                    0.0673, 0.0785, 0.0314, 0.0010, 0.0609, 0.0614, 0.1002,
                    0.0316, 0.0108, 0.0131, 0.0044, 0.0127, 0.0011};
            for (int i = 0; i < 26; i++)
                frqArr[i] = (double) lettersArr[i]/counter;
            double var = 0;
            for (int i = 0; i < 26; i++)
                var += Math.pow(FrqArr[i] - frqArr[i], 2);
            return (var < 0.004);
        } catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }

    /**
     * This function reads text of the file in URL address
     * @return string of file text
     * @throws IOException if there are input / output exceptions
     */
    public String readText() throws IOException {
        String str;
        Document doc = Jsoup.connect(myStr[1]).get();
        str = doc.text();
        str = str.toLowerCase();
        return str;
    }

    /**
     * This function counts the frequency of the letters in the language
     * @throws Exception if there are input / output exceptions or deviations in the program activity
     */
    public void counteringLetters() throws Exception {
        try {
            String str = readText();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    lettersArr[str.charAt(i) - 'a']++;
                    counter++;
                }
            }
        }
        catch (IllegalArgumentException | MalformedURLException e) {
            throw new GeneralException("bad url");
        } catch (IOException e) {
            throw new GeneralException("error");
        }
        catch (Exception e) {
            throw new GeneralException(e.getMessage());
        }
    }
    private final String[] myStr;
    private final int[] lettersArr;
    private int counter;
}

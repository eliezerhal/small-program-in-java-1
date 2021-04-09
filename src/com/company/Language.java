package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Language implements command {
    public Language(String[] str) {
        myStr = str;
        lettersArr = new int[26];
        counter = 0;
    }
    public boolean checkingContentType() {
        if(myStr[2].equals("english"))
            return isEnglish();
        return false;
    }

    public boolean isEnglish() {
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
            System.out.println(var);
            return (var < 0.04);
        } catch (Exception e) {
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
    public void counteringLetters() {
        try {
            String str = readText();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    lettersArr[str.charAt(i) - 'a']++;
                    counter++;
                }
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private final String[] myStr;
    private final int[] lettersArr;
    private int counter;
}

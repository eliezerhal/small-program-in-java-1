package com.company;

import java.util.Scanner;

public class In {
    public In() {}
    public void getIn() {
        Scanner input = new Scanner(System.in);
        myIn = input.nextLine().split(" ");
        System.out.println(input);
    }
    public command command() throws GeneralException, ExitException {
        String str = myIn[0];
        return switch (str) {
            case "t" -> new Type(myIn);
            case "w" -> new Word(myIn);
            case "i" -> new Img(myIn);
            case "l" -> new Language(myIn);
            case "q" -> throw new ExitException();
            default -> throw new GeneralException("invalid command");
        };
    }
    private String[] myIn;
}

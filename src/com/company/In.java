package com.company;

import java.util.Scanner;

/**
 * This is a class for the input/output operations
 */
public class In {
    /**
     * This is the class constructor function
     */
    public In() {}
    public void getIn() {
        Scanner input = new Scanner(System.in);
        myIn = input.nextLine().split(" ");
        System.out.println(input);
    }

    /**
     * This is factory that build instances of the commands classes
     * @return instance of the command
     * @throws GeneralException if the command is invalid
     * @throws ExitException for the end of program if the command is 'q'
     */
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

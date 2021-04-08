package com.company;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command:");
            try {
                In input = new In();
                input.getIn();
                command cmd = input.command();
                System.out.println(cmd.checkingContentType());
            }
            catch (ExitException e) {
                break;
            }
            catch (GeneralException e) {
                if(e.getMessage().equals("Index 1 out of bounds for length 1"))
                    System.out.println("false");
                else
                    System.err.println(e.getMessage());
            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

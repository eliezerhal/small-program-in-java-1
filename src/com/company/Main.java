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
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

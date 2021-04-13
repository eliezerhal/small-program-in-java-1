package com.company;

/**
 * This program works like a web proxy with five kind of commands
 * @author Eli Haltovski
 * id: 305462137
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
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

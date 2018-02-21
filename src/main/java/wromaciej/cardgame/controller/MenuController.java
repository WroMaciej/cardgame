package wromaciej.cardgame.controller;

import java.util.Scanner;

/**
 Input from keyboard
 **/
public abstract class MenuController {

    public static String inputString;
    private static Scanner inputScanner=new Scanner(System.in);

    public static String getInput(){
        inputString= inputScanner.nextLine();
        return inputString;
    }
}

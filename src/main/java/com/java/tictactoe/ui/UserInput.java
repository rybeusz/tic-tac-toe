package com.java.tictactoe.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by pati on 13.06.17.
 */
public class UserInput {
    public Integer chooseOption() throws InputMismatchException {
        Integer userOption;
        try {
            Scanner scan = new Scanner(System.in);
            userOption = scan.nextInt();
        } catch (InputMismatchException e) {
            userOption = -1;
        }
        return userOption;
    }
}

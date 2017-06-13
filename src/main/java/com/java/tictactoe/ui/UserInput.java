package com.java.tictactoe.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by pati on 13.06.17.
 */
public class UserInput {
    public Integer chooseCell() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        Integer cellNumber = null;
        cellNumber = scan.nextInt();
        return cellNumber;
    }
}

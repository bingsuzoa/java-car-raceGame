package com.gameRace.view;

import java.util.Scanner;

public class InputView {
    private static final InputView inputView = new InputView();
    private final OutputView outputView;
    private final Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
        outputView = OutputView.getOutputView();
    }

    public static InputView getInputView() {
        return inputView;
    }

    public String getCarNameInput() {
        outputView.printString(Message.CAR_NAMES_INPUT_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public String getTryRoundInput() {
        outputView.printString(Message.TRY_NUMBER_INPUT_MESSAGE.getMessage());
        return scanner.nextLine();
    }
}

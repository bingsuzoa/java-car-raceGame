package com.gameRace.view;


import com.gameRace.gameException.InvalidTryRoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final int INVALID_TRY_ROUND = 0;
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


    public int getTryRoundInput() {
        try {
            outputView.printString(Message.TRY_NUMBER_INPUT_MESSAGE.getMessage());
            int tryRound = scanner.nextInt();
            validateTryRound(tryRound);
            return tryRound;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            outputView.printString(new InvalidTryRoundException().getMessage());
        } catch (InvalidTryRoundException e) {
            scanner.nextLine();
            outputView.printString(e.getMessage());
        }
        return INVALID_TRY_ROUND;
    }

    private void validateTryRound(int tryRound) {
        if (tryRound <= 0) {
            throw new InvalidTryRoundException();
        }
    }

}

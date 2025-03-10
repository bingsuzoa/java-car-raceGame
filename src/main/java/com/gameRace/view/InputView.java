package com.gameRace.view;


import java.util.Scanner;

public class InputView {
    private static final InputView instance = new InputView();
    private final OutputView outputView;
    private final Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
        this.outputView = OutputView.getInstance();
    }

    public static InputView getInstance() {
        if (instance == null) {
            return new InputView();
        }
        return instance;
    }

    public String getPlayerInput(PlayOption playOption) {
        if(PlayOption.CAR_NUMBER == playOption) {
            outputView.printMessage(Message.GET_CAR_NUMBER);
            return scanner.nextLine();
        }
        outputView.printMessage(Message.GET_TRY_NUMBER);
        return scanner.nextLine();
    }

}

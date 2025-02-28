package com.gameRace.view;


public class OutputView {
    private static final OutputView outputView = new OutputView();


    public static OutputView getInstance() {
        if (outputView == null) {
            return new OutputView();
        }
        return outputView;
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printResultMessage() {
        System.out.println(Message.RESULT_MESSAGE.getMessage());
    }

    public void printResult(int moveCount) {
        for(int i = 0; i < moveCount; i++) {
            System.out.print(Message.CAR.getMessage());
        }
        System.out.println();
    }

    public void printBlank() {
        System.out.println();
    }
}

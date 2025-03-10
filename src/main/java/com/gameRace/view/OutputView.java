package com.gameRace.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getOutputView() {
        return outputView;
    }

    public void printString(String message) {
        System.out.println(message);
    }

    public void printWinnerNames(List<String> winnerNameList) {
        String winnerNames = winnerNameList.stream()
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames);
    }
}

package com.example.calculatorprogram;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML
    private TextField display;

    private double firstNumber = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleNumber(javafx.event.ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();

        if (start) {
            display.setText("");
            start = false;
        }

        display.setText(display.getText() + value);
    }

    @FXML
    private void handleOperator(javafx.event.ActionEvent event) {
        operator = ((javafx.scene.control.Button) event.getSource()).getText();
        firstNumber = Double.parseDouble(display.getText());
        start = true;
    }

    @FXML
    private void handleEqual() {
        double secondNumber = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;

            case "-":
                result = firstNumber - secondNumber;
                break;

            case "*":
                result = firstNumber * secondNumber;
                break;

            case "/":
                result = firstNumber / secondNumber;
                break;
        }

        display.setText(String.valueOf(result));
        start = true;
    }
}

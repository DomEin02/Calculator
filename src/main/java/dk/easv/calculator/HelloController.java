package dk.easv.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private TextField txtMathField;

    private String displayedText = "";

    private ArrayList<Double> doubleArrayList = new ArrayList<>();

    private ArrayList<String> operators = new ArrayList<>();

    private boolean preOperator = false;

    private boolean inOperator = false;

    private boolean hasComma = false;

    @FXML
    private void onBtnClear(ActionEvent actionEvent) {

        displayedText = "";
        doubleArrayList = new ArrayList<>();
        operators = new ArrayList<>();
        preOperator = false;
        inOperator = false;
        updateTxtField();
    }

    @FXML
    private void onBtnPlusMinus(ActionEvent actionEvent) {
        writePreOperation("±");
    }

    @FXML
    private void onBtnProcent(ActionEvent actionEvent) {
        writePreOperation("%");
    }

    @FXML
    private void onBtnDivide(ActionEvent actionEvent) {
        writeOperation("*");
    }

    @FXML
    private void onBtnSeven(ActionEvent actionEvent) {
        writeNumber("7");
    }

    @FXML
    private void onBtnEight(ActionEvent actionEvent) {
        writeNumber("8");
    }

    @FXML
    private void onBtnNine(ActionEvent actionEvent) {
        writeNumber("9");
    }

    @FXML
    private void onBtnMultiply(ActionEvent actionEvent) {
        writeOperation("*");
    }

    @FXML
    private void onBtnFour(ActionEvent actionEvent) {
        writeNumber("4");
    }

    @FXML
    private void onBtnFive(ActionEvent actionEvent) {
        writeNumber("5");
    }

    @FXML
    private void onBtnSix(ActionEvent actionEvent) {
        writeNumber("6");
    }

    @FXML
    private void onBtnMinus(ActionEvent actionEvent) {
        writeOperation("-");
    }

    @FXML
    private void onBtnOne(ActionEvent actionEvent) {
        writeNumber("1");
    }

    @FXML
    private void onBtnTwo(ActionEvent actionEvent) {
        writeNumber("2");
    }

    @FXML
    private void onBtnThree(ActionEvent actionEvent) {
        writeNumber("3");
    }

    @FXML
    private void onBtnPlus(ActionEvent actionEvent) {
        writeOperation("+");
    }

    @FXML
    private void onBtnZero(ActionEvent actionEvent) {
        writeNumber("0");
    }

    @FXML
    private void onBtnComma(ActionEvent actionEvent) {
        addComma();
    }

    @FXML
    private void onBtnEquals(ActionEvent actionEvent) {
        calculateResult();
    }

    private void updateTxtField() {
        txtMathField.setText(displayedText);
    }

    private void writeNumber(String number) {
        if(inOperator)
        {
            operators.add(displayedText);
            inOperator = false;
            hasComma = false;
            displayedText = number;
        }
        else if(!preOperator)
        {
            displayedText = displayedText + number;
        }
        updateTxtField();
    }
    private void addComma() {
        if(!preOperator && !inOperator && !hasComma && !displayedText.isEmpty()) {
            displayedText = displayedText + ".";
            updateTxtField();
        }
    }
    private void writePreOperation(String thePreOperator) {
        if(!inOperator && !preOperator)
        {
            inOperator = true;
            switch (thePreOperator) {
                case "%":
                    doubleArrayList.add(Double.parseDouble(displayedText)/100);
                    break;
                case "±":
                    doubleArrayList.add(Double.parseDouble("-"+displayedText));
                    break;
            }
            displayedText = displayedText + thePreOperator;
        }
        updateTxtField();
    }
    private void writeOperation(String theOperator) {
        if (preOperator) {
            preOperator = false;
            inOperator = true;
            displayedText = theOperator;
        } else if (inOperator) {
            displayedText = theOperator;
        } else if (!displayedText.isEmpty()) {
            inOperator = true;
            doubleArrayList.add(Double.parseDouble(displayedText));
            displayedText = theOperator;
        }
        updateTxtField();
    }
    private void calculateResult() {
        if(!operators.isEmpty()) {
            if(!displayedText.isEmpty()) {
                doubleArrayList.add(Double.parseDouble(displayedText));
            }
            if(doubleArrayList.size() == operators.size()) {
                operators.removeLast();
            }
            int optationDone = 0;
            for (int i = 0; i < operators.size(); i++) {
                String symbol = operators.get(i);
                if(symbol.equals("*")) {
                    double result = doubleArrayList.get(i-optationDone) * doubleArrayList.get(i +1 -optationDone);
                    doubleArrayList.set(i-optationDone, result);
                    doubleArrayList.remove(i+1-optationDone);
                    optationDone++;
                }
                else if(symbol.equals("/")) {
                    double result = doubleArrayList.get(i-optationDone) / doubleArrayList.get(i +1 -optationDone);
                    doubleArrayList.set(i-optationDone, result);
                    doubleArrayList.remove(i+1-optationDone);
                    optationDone++;
                }
            }
            optationDone = 0;
            for (int i = 0; i < operators.size(); i++) {
                String symbol = operators.get(i);
                if(symbol.equals("+")) {
                    double result = doubleArrayList.get(i-optationDone) + doubleArrayList.get(i +1 -optationDone);
                    doubleArrayList.set(i-optationDone, result);
                    doubleArrayList.remove(i+1-optationDone);
                    optationDone++;
                }
                else if(symbol.equals("-")) {
                    double result = doubleArrayList.get(i-optationDone) - doubleArrayList.get(i +1 -optationDone);
                    doubleArrayList.set(i-optationDone, result);
                    doubleArrayList.remove(i+1-optationDone);
                    optationDone++;
                } else if (symbol.equals("*")||symbol.equals("/")) {
                    optationDone++;
                }
            }
            displayedText = String.valueOf(doubleArrayList.getFirst());
            updateTxtField();
        }

    }

}

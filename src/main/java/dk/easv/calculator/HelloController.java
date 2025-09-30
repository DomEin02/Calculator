package dk.easv.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField txtMathField;

    private String displayedText = "";

    @FXML
    private void onBtnClear(ActionEvent actionEvent) {
        displayedText = "";
    }

    @FXML
    private void onBtnPlusMinus(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnProcent(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnDivide(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnSeven(ActionEvent actionEvent) {
        updateTxtField("7");
    }

    @FXML
    private void onBtnEight(ActionEvent actionEvent) {
        updateTxtField("8");
    }

    @FXML
    private void onBtnNine(ActionEvent actionEvent) {
        updateTxtField("9");
    }

    @FXML
    private void onBtnMultiply(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnFour(ActionEvent actionEvent) {
        updateTxtField("4");
    }

    @FXML
    private void onBtnFive(ActionEvent actionEvent) {
        updateTxtField("5");
    }

    @FXML
    private void onBtnSix(ActionEvent actionEvent) {
        updateTxtField("6");
    }

    @FXML
    private void onBtnMinus(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnOne(ActionEvent actionEvent) {
        updateTxtField("1");
    }

    @FXML
    private void onBtnTwo(ActionEvent actionEvent) {
        updateTxtField("2");
    }

    @FXML
    private void onBtnThree(ActionEvent actionEvent) {
        updateTxtField("3");
    }

    @FXML
    private void onBtnPlus(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnZero(ActionEvent actionEvent) {
        updateTxtField("0");
    }

    @FXML
    private void onBtnComma(ActionEvent actionEvent) {
    }

    @FXML
    private void onBtnEquals(ActionEvent actionEvent) {
    }

    private void updateTxtField(String input) {
        displayedText = displayedText + input;
        txtMathField.setText(displayedText);
    }
}

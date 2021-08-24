package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;


public class Controller {
    private BigDecimal chap;
    private String belgilar;
    private boolean raqamkritish;

    @FXML
    private TextField text;

    public Controller() {
        this.chap = BigDecimal.ZERO;
        this.belgilar = "";
        this.raqamkritish = false;
    }
    public void OnButtonClick(ActionEvent actionEvent) {
        Button button = (Button)actionEvent.getSource();
        final String buttonT = button.getText();
        if (buttonT.equals("C")) {
            if (buttonT.equals("C")) {
                chap = BigDecimal.ZERO;
            }
            belgilar = "";
            raqamkritish = false;
            text.setText("0");
            return;
        }
        if (buttonT.matches("[0-9\\.]")) {
            if (!raqamkritish) {
                raqamkritish = true;
                text.clear();
            }
            text.appendText(buttonT);
            return;
        }
        if (buttonT.matches("[＋－×÷]")) {
            chap = new BigDecimal(text.getText());
            belgilar = buttonT;
            raqamkritish = false;
            return;
        }

        if (buttonT.equals("=")) {
            final BigDecimal ung = raqamkritish ? new BigDecimal(text.getText()) : chap;
            chap = hisoblash(belgilar, chap, ung);
            text.setText(chap.toString());
            raqamkritish = false;
            return;
        }
    /*    Button button = (Button) actionEvent.getSource();
        if (button.equals(clear)) {
            text.setText("0");
        }
        if (button.getText().matches("[0-9\\.]")){
            if (text.getText().equals("0")){
                text.setText("");
            }
            text.appendText(button.getText());
            return;
        }
        String ekran;
        if (button.getText().matches("[＋－×÷]")) {
            String S = text.getText();
            ekran = S;
            text.setText(button.getText());
            text.clear();
        }
        if (button.getText().equals("=")){

        }*/
    }
    public static BigDecimal hisoblash(String amallar, BigDecimal chap, BigDecimal ung) {
        switch (amallar) {
            case "＋":
                return chap.add(ung);
            case "－":
                return chap.subtract(ung);
            case "×":
                return chap.multiply(ung);
            case "÷":
                return chap.divide(ung);
            default:
        }
        return ung;
    }

    public void onKeyPressed(KeyEvent keyEvent) {

    }
}

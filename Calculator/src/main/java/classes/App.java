package classes;

import GUI.CalculatorInterface;

import javax.swing.*;

public class App extends CalculatorInterface {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorInterface calculatorInterface = new CalculatorInterface();
            CalculatorModel calculatorModel = new CalculatorModel();
            CalculatorController calculatorController = new CalculatorController(calculatorInterface, calculatorModel);
            calculatorInterface.setVisible(true);
        });
    }
}
package classes;


import GUI.CalculatorInterface;

import javax.swing.*;

/**
 * Project: ONP calculator
 * Author: Konrad Korzeniowski
 * This class is the main class of the project.
 * It sets up model, view, controller, and
 */
public class App extends CalculatorInterface {
    /**
     * Displays interface and creates instances of MVC
     * @param args - not supported
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorInterface calculatorInterface = new CalculatorInterface();
            CalculatorModel calculatorModel = new CalculatorModel();
            CalculatorController calculatorController = new CalculatorController(calculatorInterface, calculatorModel);
            calculatorInterface.setVisible(true);
        });
    }
}
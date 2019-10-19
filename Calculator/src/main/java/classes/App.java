package classes;


import GUI.CalculatorInterface;
import mathematicalOperations.AddOperation;
import mathematicalOperations.DivideOperation;
import mathematicalOperations.MultiplyOperation;
import mathematicalOperations.SubtractOperation;

import javax.swing.*;

/**
 * Project: ONP calculator
 * Author: Konrad Korzeniowski
 * This class is the main class of the project.
 * It sets up model, view, controller, and
 */
public class App extends CalculatorInterface {
    /**
     * Displays interface, creates instances of MVC and adds possible operations to the model
     * @param args - not supported
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CalculatorInterface calculatorInterface = new CalculatorInterface();
            CalculatorModel calculatorModel = new CalculatorModel();
            calculatorModel.addMathemacticalOperation("+", new AddOperation());
            calculatorModel.addMathemacticalOperation("-", new SubtractOperation());
            calculatorModel.addMathemacticalOperation("x", new MultiplyOperation());
            calculatorModel.addMathemacticalOperation("/", new DivideOperation());
            CalculatorController calculatorController = new CalculatorController(calculatorInterface, calculatorModel);
            calculatorInterface.setVisible(true);
        });
    }
}
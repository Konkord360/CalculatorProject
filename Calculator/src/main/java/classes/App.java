package classes;


import GUI.CalculatorInterface;
import mathematicalOperations.AddOperation;
import mathematicalOperations.DivideOperation;
import mathematicalOperations.MultiplyOperation;
import mathematicalOperations.SubrtactOperation;

import javax.swing.*;

public class App extends CalculatorInterface {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            CalculatorInterface calculatorInterface = new CalculatorInterface();
            CalculatorModel calculatorModel = new CalculatorModel();
            calculatorModel.addMathemacticalOperation("+", new AddOperation());
            calculatorModel.addMathemacticalOperation("-", new SubrtactOperation());
            calculatorModel.addMathemacticalOperation("x", new MultiplyOperation());
            calculatorModel.addMathemacticalOperation("/", new DivideOperation());
            CalculatorController calculatorController = new CalculatorController(calculatorInterface, calculatorModel);
            calculatorInterface.setVisible(true);
        });
    }
}
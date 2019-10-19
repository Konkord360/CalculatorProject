package classes;

import GUI.CalculatorInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Takes information from user interface, then gives it to the Model and vice versa.
 */
class CalculatorController {
    private CalculatorInterface calculatorInterface;
    private CalculatorModel calculatorModel;

    /**
     * Constructs controller for given interface and model
     */
    CalculatorController(CalculatorInterface calculatorInterface, CalculatorModel calculatorModel) {
        this.calculatorInterface = calculatorInterface;
        this.calculatorModel = calculatorModel;
        this.calculatorInterface.addActionListenersForTextWritingButtons(new PrintingButtonListener());
        this.calculatorInterface.addClearButtonActionListener(new ClearButtonListener());
        this.calculatorInterface.addBackButtonActionListener(new BackButtonListener());
        this.calculatorInterface.addEqualButtonActionListener(new EqualButtonListener());
    }

    /**
     * Adds actionListener to a text printing field
     */
    class PrintingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText(calculatorInterface.getEquation().concat(e.getActionCommand()));
        }
    }

    /**
     * Adds actionListener to the clearing button
     */
    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText("");
        }
    }

    /**
     * Adds actionListener to the backspace button
     */
    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText(calculatorInterface.getEquation().substring(0, calculatorInterface.getEquation().length() - 1));
        }
    }

    /**
     * Adds actionListener to the Equal sign button
     */
    class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setTextOnPreviousOperationField(calculatorInterface.getEquation());
            calculatorInterface.setText(calculatorModel.calculate(calculatorInterface.getEquation()));
        }
    }
}
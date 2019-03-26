package classes;

import GUI.CalculatorInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorController {
    private CalculatorInterface calculatorInterface;
    private CalculatorModel calculatorModel;

    CalculatorController(CalculatorInterface calculatorInterface, CalculatorModel calculatorModel) {
        this.calculatorInterface = calculatorInterface;
        this.calculatorModel = calculatorModel;
        this.calculatorInterface.addActionListenersForTextWritingButtons(new PrintingButtonListener());
        this.calculatorInterface.addClearButtonActionListener(new ClearButtonListener());
        this.calculatorInterface.addBackButtonActionListener(new BackButtonListener());
        this.calculatorInterface.addEqualButtonActionListener(new EqualButtonListener());
    }

    class PrintingButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText(calculatorInterface.getEquation().concat(e.getActionCommand()));
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText("");
        }
    }

    class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText(calculatorInterface.getEquation().substring(0, calculatorInterface.getEquation().length() - 1));
        }
    }

    class EqualButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorInterface.setText(calculatorModel.calculate(calculatorInterface.getEquation()));
        }
    }
}
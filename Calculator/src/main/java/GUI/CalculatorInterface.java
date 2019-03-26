package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CalculatorInterface extends JFrame {
    private JTextField equationField;
    private JButton CEButton;
    private JButton CButton;
    private JButton backButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton a0Button;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JButton equalButton;
    private JButton comaButton;
    private JButton minusPlusButton;
    private JPanel rootPanel;
    private JButton rBracket;
    private JButton lBracket;

    public CalculatorInterface() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUpNamesForTests();
        add(rootPanel);
        setTitle("Calculator");
        setSize(400, 500);
    }

    private void setUpNamesForTests() {
        CEButton.setName("CEButton");
        CButton.setName("CButton");
        backButton.setName("backButton");
        a7Button.setName("a7Button");
        a8Button.setName("a8Button");
        a9Button.setName("a9Button");
        a4Button.setName("a4Button");
        a5Button.setName("a5Button");
        a6Button.setName("a6Button");
        a3Button.setName("a3Button");
        a2Button.setName("a2Button");
        a1Button.setName("a1Button");
        a0Button.setName("a0Button");
        divideButton.setName("divideButton");
        multiplyButton.setName("multiplyButton");
        subtractButton.setName("subtractButton");
        addButton.setName("addButton");
        equalButton.setName("equalButton");
        comaButton.setName("comaButton");
        minusPlusButton.setName("minusPlusButton");
        equationField.setName("equationField");
        rootPanel.setName("rootPanel");
        lBracket.setName("lBracket");
        rBracket.setName("rBracket");
    }

    public void addActionListenersForTextWritingButtons(ActionListener listenerForNumberPrinting) {
        a9Button.addActionListener(listenerForNumberPrinting);
        a8Button.addActionListener(listenerForNumberPrinting);
        a7Button.addActionListener(listenerForNumberPrinting);
        a6Button.addActionListener(listenerForNumberPrinting);
        a5Button.addActionListener(listenerForNumberPrinting);
        a4Button.addActionListener(listenerForNumberPrinting);
        a3Button.addActionListener(listenerForNumberPrinting);
        a2Button.addActionListener(listenerForNumberPrinting);
        a1Button.addActionListener(listenerForNumberPrinting);
        a0Button.addActionListener(listenerForNumberPrinting);
        divideButton.addActionListener(listenerForNumberPrinting);
        multiplyButton.addActionListener(listenerForNumberPrinting);
        subtractButton.addActionListener(listenerForNumberPrinting);
        addButton.addActionListener(listenerForNumberPrinting);
        comaButton.addActionListener(listenerForNumberPrinting);
        lBracket.addActionListener(listenerForNumberPrinting);
        rBracket.addActionListener(listenerForNumberPrinting);
    }

    public void addClearButtonActionListener(ActionListener clearButtonListener) {
        CButton.addActionListener(clearButtonListener);
    }

    public void addBackButtonActionListener(ActionListener backButtonActionListener) {
        backButton.addActionListener(backButtonActionListener);
    }

    public void addEqualButtonActionListener(ActionListener equalButtonListener) {
        equalButton.addActionListener(equalButtonListener);
    }

    public String getEquation() {
        return String.valueOf(this.equationField.getText());
    }

    public void setText(String text) {
        this.equationField.setText(text);
    }
}
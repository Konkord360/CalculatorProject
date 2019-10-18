package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * GUI for the calculator in SWING
 */
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
    private JTextField previousOperationField;

    /**
     * Sets basic parameters of the GUI
     */
    public CalculatorInterface() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUpNamesForTests();
        add(rootPanel);
        setTitle("Calculator");
        setSize(400, 500);
    }

    /**
     * sets up button names. Required for tests.
     */
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
        previousOperationField.setName("previousOperationField");
    }

    /**
     * Adds listeners for Text writing buttons
     * @param listenerForNumberPrinting listener which prints sign from the button to the equation field.
     */
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

    /**
     *
     * @param clearButtonListener listener for button which clears the equation field
     */
    public void addClearButtonActionListener(ActionListener clearButtonListener) {
        CButton.addActionListener(clearButtonListener);
    }

    /**
     *
     * @param backButtonActionListener listener for button which deletes last written sign
     */
    public void addBackButtonActionListener(ActionListener backButtonActionListener) {
        backButton.addActionListener(backButtonActionListener);
    }

    /**
     *
     * @param equalButtonListener listener for button which indicates that equation
     *                           from text field should be calculated
     */
    public void addEqualButtonActionListener(ActionListener equalButtonListener) {
        equalButton.addActionListener(equalButtonListener);
    }

    /**
     *
     * @return equation from text field
     */
    public String getEquation() {
        return String.valueOf(this.equationField.getText());
    }

    /**
     *
     * @param text to be printed on the text field
     */
    public void setText(String text) {
        this.equationField.setText(text);
    }

    /**
     *
     * @param text to be written in the history field
     */
    public void setTextOnPreviousOperationField(String text) {
        this.previousOperationField.setText(text);
    }
}
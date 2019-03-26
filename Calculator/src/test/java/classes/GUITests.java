package classes;

import GUI.CalculatorInterface;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GUITests extends AssertJSwingJUnitTestCase {
    private FrameFixture window;

    @Override
    public void onSetUp() {
        CalculatorInterface frame = GuiActionRunner.execute(CalculatorInterface::new);
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController = new CalculatorController(frame, calculatorModel);

        window = new FrameFixture(robot(), frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void checkIfa0ButtonPuts0InEquationField() {
        window.button("a0Button").click();
        window.textBox("equationField").requireText("0");
    }

    @Test
    public void checkIfa1ButtonPuts1InEquationField() {
        window.button("a1Button").click();
        window.textBox("equationField").requireText("1");
    }

    @Test
    public void checkIfa2ButtonPuts2InEquationField() {
        window.button("a2Button").click();
        window.textBox("equationField").requireText("2");
    }

    @Test
    public void checkIfa3ButtonPuts3InEquationField() {
        window.button("a3Button").click();
        window.textBox("equationField").requireText("3");
    }

    @Test
    public void checkIfa4ButtonPuts4InEquationField() {
        window.button("a4Button").click();
        window.textBox("equationField").requireText("4");
    }

    @Test
    public void checkIfa5ButtonPuts5InEquationField() {
        window.button("a5Button").click();
        window.textBox("equationField").requireText("5");
    }

    @Test
    public void checkIfa6ButtonPuts6InEquationField() {
        window.button("a6Button").click();
        window.textBox("equationField").requireText("6");
    }

    @Test
    public void checkIfa7ButtonPuts7InEquationField() {
        window.button("a7Button").click();
        window.textBox("equationField").requireText("7");
    }

    @Test
    public void checkIfa8ButtonPuts8InEquationField() {
        window.button("a8Button").click();
        window.textBox("equationField").requireText("8");
    }

    @Test
    public void checkIfa9ButtonPuts9InEquationField() {
        window.button("a9Button").click();
        window.textBox("equationField").requireText("9");
    }

    @Test
    public void checkIfAnAddButtonPutsPlusInEquationField() {
        window.button("addButton").click();
        window.textBox("equationField").requireText("+");
    }

    @Test
    public void checkIfSubtractButtonPutsMinusInEquationField() {
        window.button("subtractButton").click();
        window.textBox("equationField").requireText("-");
    }

    @Test
    public void checkIfDivideButtonPutsSlashInEquationField() {
        window.button("divideButton").click();
        window.textBox("equationField").requireText("/");
    }

    @Test
    public void checkIfMultiplyButtonPutsStarInEquationField() {
        window.button("multiplyButton").click();
        window.textBox("equationField").requireText("x");
    }

    @Test
    public void checkIfComaButtonPutsComaInEquationField() {
        window.button("comaButton").click();
        window.textBox("equationField").requireText(".");
    }

    @Test
    public void checkIfTextFromButtonsIsCorrectlyDisplayedInTextField() {
        window.button("a7Button").click();
        window.button("divideButton").click();
        window.button("a6Button").click();
        window.button("addButton").click();
        window.button("a4Button").click();
        window.button("comaButton").click();
        window.button("a5Button").click();
        window.button("multiplyButton").click();
        window.button("a9Button").click();
        window.button("subtractButton").click();
        window.button("a1Button").click();
        window.textBox("equationField").requireText("7/6+4.5x9-1");
    }

    @Test
    public void checkIfCButtonClearsTextField() {
        window.button("a1Button").click();
        window.button("CButton").click();
        window.textBox("equationField").requireText("");
    }

    @Test
    public void checkIfBackButtonClearsLastEntrance() {
        window.button("a1Button").click();
        window.button("a2Button").click();
        window.button("backButton").click();
        window.textBox("equationField").requireText("1");
    }

    @Test
    public void checkIfSumButtonCorretlySolvlesEquationAndPutsItInTextField() {
        window.button("a3Button").click();
        window.button("multiplyButton").click();
        window.button("lBracket").click();
        window.button("a2Button").click();
        window.button("addButton").click();
        window.button("a5Button").click();
        window.button("rBracket").click();
        window.button("addButton").click();
        window.button("a4Button").click();
        window.button("divideButton").click();
        window.button("a2Button").click();
        window.button("addButton").click();
        window.button("a4Button").click();
        window.button("comaButton").click();
        window.button("a5Button").click();
        window.button("multiplyButton").click();
        window.button("a2Button").click();
        window.button("subtractButton").click();
        window.button("a1Button").click();
        window.textBox("equationField").requireText("3x(2+5)+4/2+4.5x2-1");
        window.button("equalButton").click();
        window.textBox("equationField").requireText("31");
    }
}
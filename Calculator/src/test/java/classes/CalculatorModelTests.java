package classes;

import mathematicalOperations.*;
import org.assertj.core.api.ThrowableAssert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorModelTests {
    @Test
    public void checkIfCalculatorCanProperlyCalculateSimpleAddition() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 + 2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("5");
    }

    @Test
    public void checkIfCalculatorCanProperlySubtract() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 - 2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("1");
    }

    @Test
    public void checkIfCalculatorCanProperlyMultiply() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 x 2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("6");
    }

    @Test
    public void checkIfCalculatorCanProperlyDivide() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "6 / 2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("3");
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateComplicatedEquation() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "(3 + 2) x (3 + 1) / 2 - 4 / 2 + (3 + 4 x (2 + 3))+ 0.5";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("31.5");
    }

    @Test
    public void checkIfCalculatorCanDetectOperatorCorrectly() {
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.isOperator("+")).isTrue();
        assertThat(calculatorModel.isOperator("5")).isFalse();
    }

    @Test
    public void checkIfCalculatorProperlyDetectsOperations() {
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.getProperOperation("+")).isInstanceOf(AddOperation.class);
        assertThat(calculatorModel.getProperOperation("-")).isInstanceOf(SubrtactOperation.class);
        assertThat(calculatorModel.getProperOperation("x")).isInstanceOf(MultiplyOperation.class);
        assertThat(calculatorModel.getProperOperation("/")).isInstanceOf(DivideOperation.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfCalculatorThrowsExceptionDuringRecognizingOperation() {
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThatIllegalArgumentException().isThrownBy((ThrowableAssert.ThrowingCallable) calculatorModel.getProperOperation(":"));
    }
}
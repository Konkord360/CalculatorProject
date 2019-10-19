package classes;

import mathematicalOperations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for calculating functionality
 */
public class CalculatorModelTests {
    private CalculatorModel calculatorModel;

    @BeforeClass
    public  void setUpCalculatorModelWithMathematicalOpeartions(){
        this.calculatorModel = new CalculatorModel();
        this.calculatorModel.addMathemacticalOperation("+", new AddOperation());
        this.calculatorModel.addMathemacticalOperation("-", new SubrtactOperation());
        this.calculatorModel.addMathemacticalOperation("x", new MultiplyOperation());
        this.calculatorModel.addMathemacticalOperation("/", new DivideOperation());
    }

    @Test
    public void checkIfCalculatorCanProperlyHandlesSinglePositiveCharacter() {
        String equation = "3";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("3");
    }

    @Test
    public void checkIfCalculatorCanProperlyHandlesSingleNegativeCharacter() {
        String equation = "-3";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("-3");
    }

    @Test
    public void checkIfCalculatorCanProperlyHandlesSingleNegtaiveCharacters() {
        String equation = "3--3";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("-3");
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateSimpleAddition() {
        String equation = "3 + 2";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("5");
    }

    @Test
    public void checkIfCalculatorCanProperlySubtract() {
        String equation = "3 - 2";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("1");
    }

    @Test
    public void checkIfCalculatorCanProperlyMultiply() {
        String equation = "3 x 2";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("6");
    }

    @Test
    public void checkIfCalculatorCanProperlyDivide() {
        String equation = "6 / 2";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("3");
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateComplicatedEquation() {
        String equation = "(3 + 2) x (3 + 1) / 2 - 4 / 2 + (3 + 4 x (2 + 3))+ 0.5";
        assertThat(this.calculatorModel.calculate(equation)).isEqualTo("31.5");
    }

    @Test
    public void checkIfCalculatorCanDetectOperatorCorrectly() {
        assertThat(this.calculatorModel.isRecognizedOperator("+")).isTrue();
    }

    @Test
    public void checkIfCalculatorWontDetectNumberAsOperator() {
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(this.calculatorModel.isRecognizedOperator("5")).isFalse();
    }

    @Test
    public void checkIfCalculatorProperlyDetectsOperations() {
        assertThat(this.calculatorModel.getProperOperation("+")).isInstanceOf(AddOperation.class);
        assertThat(this.calculatorModel.getProperOperation("-")).isInstanceOf(SubrtactOperation.class);
        assertThat(this.calculatorModel.getProperOperation("x")).isInstanceOf(MultiplyOperation.class);
        assertThat(this.calculatorModel.getProperOperation("/")).isInstanceOf(DivideOperation.class);
    }

    //@Test(expected = IllegalArgumentException.class)
    //public void checkIfCalculatorThrowsExceptionDuringRecognizingOperation() {
    //    assertThatIllegalArgumentException().isThrownBy((ThrowableAssert.ThrowingCallable) this.calculatorModel.getProperOperation(":"));
    //}
}
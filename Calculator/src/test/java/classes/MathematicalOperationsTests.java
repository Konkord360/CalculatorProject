package classes;

import mathematicalOperations.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathematicalOperationsTests {

    @Test
    public void checkIfCalculatorCanProperlyAddTwoNumbers() {
        MathematicalOperation mathematicalOperation = new AddOperation();
        assertThat(mathematicalOperation.calculate("5", "10")).isEqualTo("15");
    }

    @Test
    public void checkIfCalculatorCanProperlySubtractTwoNumbers() {
        MathematicalOperation mathematicalOperation = new SubrtactOperation();
        assertThat(mathematicalOperation.calculate("10", "5")).isEqualTo("5");
    }

    @Test
    public void checkIfCalculatorCanProperlyMultiplyTwoNumbers() {
        MathematicalOperation mathematicalOperation = new MultiplyOperation();
        assertThat(mathematicalOperation.calculate("5", "10")).isEqualTo("50");
    }

    @Test
    public void checkIfCalculatorCanProperlyDivideTwoNumbers() {
        MathematicalOperation mathematicalOperation = new DivideOperation();
        assertThat(mathematicalOperation.calculate("10", "5")).isEqualTo("2");
    }

}

package classes;

import com.sun.org.apache.xpath.internal.operations.Div;
import junit.framework.TestCase;
import mathematicalOperations.*;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicTests{
    @Test
    public void checkIfCalculatorCanProperlyAddTwoNumbers(){
        MathematicalOperation mathematicalOperation = new AddOperation();
        assertThat(mathematicalOperation.calculate("5","10")).isEqualTo("15");
    }

    @Test
    public void checkIfCalculatorCanProperlySubtractTwoNumbers(){
        MathematicalOperation mathematicalOperation = new SubrtactOperation();
        assertThat(mathematicalOperation.calculate("10","5")).isEqualTo("5");
    }

    @Test
    public void checkIfCalculatorCanProperlyMultiplyTwoNumbers(){
        MathematicalOperation mathematicalOperation = new MultiplyOperation();
        assertThat(mathematicalOperation.calculate("5", "10")).isEqualTo("50");
    }

    @Test
    public void checkIfCalculatorCanProperlyDivideTwoNumbers(){
        MathematicalOperation mathematicalOperation = new DivideOperation();
        assertThat(mathematicalOperation.calculate("10", "5")).isEqualTo("2");
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateSimpleAddition(){
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 + 2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("5");
    }

    @Test
    public void checkIfCalculatorCanProperlySubtract(){
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
    public void checkIfCalculatorCanProperlyCalculateEquationWithAdditionAndSubtraction(){
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 + 2 - 1";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("4");
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateComplicatedEquation(){
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "(3 + 2) x (3 + 1) / 2 - 4 / 2 + (3 + 4 x (2 + 3))";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("31");
    }

    @Test
    public void checkIfCalculatorCanProperly(){
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "((2+7)/3+(14-3)x4)/2";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("23.5");
    }

    @Test
    public void checkIfCalculatorCanDetectOperatorCorrectly(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.isOperator("+")).isTrue();
        assertThat(calculatorModel.isOperator("5")).isFalse();
    }

    @Test
    public void checkIfCalculatorProperlyDetectsOperations(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.getProperOperation("+")).isInstanceOf(AddOperation.class);
        assertThat(calculatorModel.getProperOperation("-")).isInstanceOf(SubrtactOperation.class);
        assertThat(calculatorModel.getProperOperation("x")).isInstanceOf(MultiplyOperation.class);
        assertThat(calculatorModel.getProperOperation("/")).isInstanceOf(DivideOperation.class);
    }
//TODO napisać testy do isOperator, zastosować polimorfizm do operacji matematycznych
}
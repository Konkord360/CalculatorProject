package classes;

import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LogicTests{
    @Test
    public void checkIfCalculatorCanProperlyAddTwoNumbers(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.add(new BigDecimal(5), new BigDecimal(10))).isEqualTo(new BigDecimal(15));
    }

    @Test
    public void checkIfCalculatorCanProperlySubtractTwoNumbers(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.subtract(new BigDecimal(10), new BigDecimal(5))).isEqualTo(new BigDecimal(5));
    }

    @Test
    public void checkIfCalculatorCanProperlyMultiplyTwoNumbers(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.multiply(new BigDecimal(5), new BigDecimal(10))).isEqualTo(new BigDecimal(50));
    }

    @Test
    public void checkIfCalculatorCanProperlyDivideTwoNumbers(){
        CalculatorModel calculatorModel = new CalculatorModel();
        assertThat(calculatorModel.divide(new BigDecimal(10), new BigDecimal(5))).isEqualTo(new BigDecimal(2));
    }

    @Test
    public void checkIfCalculatorCanProperlyCalculateEquationWithAdditionAndSubtraction(){
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 + 2 - 1";
        assertThat(calculatorModel.calculate(equation)).isEqualTo("4");
    }

}
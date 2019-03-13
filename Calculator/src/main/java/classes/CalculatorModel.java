package classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CalculatorModel {
    String result;
    String equation;

    CalculatorModel() {
    }

    String calculate(String equation) {
        String onpEquation = ONPConverter.convertEquationToONP(equation);

        //List<Character> everyPartOfEquation = putEveryPartOfEquationIntoList(equation);
        //this.equation = equation;
        //this.result = "";
        return result;
    }


    public String getResult() {
        return this.result;
    }

    public BigDecimal add(BigDecimal augend, BigDecimal addend) {
        return augend.add(addend);
    }

    public BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
        return minuend.subtract(subtrahend);
    }

    public BigDecimal multiply(BigDecimal multiplicand, BigDecimal multiplier) {
        return multiplicand.multiply(multiplier);
    }

    public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        return dividend.divide(divisor);
    }
}
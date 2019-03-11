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
        List<Character> everyPartOfEquation = putEveryPartOfEquationIntoList(equation);
        //TODO parse expresion to ONP and calulate its value
        //this.equation = equation;
        //this.result = "";
        return result;
    }

    List<Character> putEveryPartOfEquationIntoList(String equation) {
        List<Character> equationList = new ArrayList<>();

        for (char character : equation.replaceAll("\\s+", "").toCharArray())
            equationList.add(character);

        return equationList;
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
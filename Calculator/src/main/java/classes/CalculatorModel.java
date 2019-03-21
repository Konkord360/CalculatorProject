package classes;

import mathematicalOperations.*;

import java.math.BigDecimal;
import java.util.*;

public class CalculatorModel {
    String result;
    String equation;

    CalculatorModel() {
    }

    String calculate(String equation) {
        String onpEquation = ONPConverter.convertEquationToONP(equation);
        Stack calculationStack = new Stack();

        while (!onpEquation.equals("")) {
            do {
                if (onpEquation.contains(" ")) {
                    calculationStack.push(onpEquation.substring(0, onpEquation.indexOf(" ")));
                    onpEquation = onpEquation.substring(onpEquation.indexOf(" ") + 1);
                } else {
                    calculationStack.push(onpEquation);
                    onpEquation = "";
                }
            } while (!isOperator(calculationStack.peek().toString()));
            executeCurrentOperation(calculationStack);
        }

        return calculationStack.pop().toString();
    }

    public boolean isOperator(String characterToBeRecognized) {
        try {
            BigDecimal conversionTest = new BigDecimal(characterToBeRecognized);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public void executeCurrentOperation(Stack stack){
        MathematicalOperation mathematicalOperation = getProperOperation(stack.pop().toString());
        String b = stack.pop().toString();
        String a = stack.pop().toString();
        stack.push(mathematicalOperation.calculate(a ,b));
    }

    public MathematicalOperation getProperOperation(String operator){
        if(operator.equals("+"))
            return new AddOperation();
        else if(operator.equals("-"))
            return new SubrtactOperation();
        else if(operator.equals("x"))
            return new MultiplyOperation();
        else if(operator.equals("/"))
            return new DivideOperation();
        else throw new IllegalArgumentException();
    }

    public String getResult() {
        return this.result;
    }
    //TODO zrobić interfejs mathematical operation
    //  klasa na każdą operację matematyczną w zależności od znaku operacjo +-/x
    //
}
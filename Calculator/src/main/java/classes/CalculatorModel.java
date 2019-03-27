package classes;

import mathematicalOperations.*;

import java.math.BigDecimal;
import java.util.Stack;

class CalculatorModel {

    String calculate(String equation) {
        String onpEquation = ONPConverter.convertEquationToONP(equation);
        Stack<String> calculationStack = new Stack<>();

        while (!onpEquation.equals("")) {
            do {
                if (onpEquation.contains(" ")) {
                    calculationStack.push(onpEquation.substring(0, onpEquation.indexOf(" ")));
                    onpEquation = onpEquation.substring(onpEquation.indexOf(" ") + 1);
                } else {
                    calculationStack.push(onpEquation);
                    onpEquation = "";
                }
            } while (!isOperator(calculationStack.peek()) && onpEquation.length() != 0);
            if (isOperator(calculationStack.peek()))
                executeCurrentOperation(calculationStack);
        }

        return new BigDecimal(calculationStack.pop()).stripTrailingZeros().toPlainString();
    }

    boolean isOperator(String characterToBeRecognized) {
        try {
            BigDecimal conversionTest = new BigDecimal(characterToBeRecognized);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private void executeCurrentOperation(Stack<String> stack) {
        MathematicalOperation mathematicalOperation = getProperOperation(stack.pop());
        String b = stack.pop();
        String a = stack.pop();
        stack.push(mathematicalOperation.calculate(a, b));
    }

    MathematicalOperation getProperOperation(String operator) {
        switch (operator) {
            case "+":
                return new AddOperation();
            case "-":
                return new SubrtactOperation();
            case "x":
                return new MultiplyOperation();
            case "/":
                return new DivideOperation();
            default:
                throw new IllegalArgumentException();
        }
    }//TODO zrobić klasę mathematicalOperationFactory i w niej robić rozpoznanie(przyda się do konwersji) dodać do operatorów operacje do konwersji na stacku
}
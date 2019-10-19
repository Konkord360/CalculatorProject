package classes;

import mathematicalOperations.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class CalculatorModel {
    private Map<String, MathematicalOperation> mathematicalOperationMap = new HashMap<>();

    String calculate(String equation) {
        String onpEquation = ONPConverter.convertEquationToONP(equation).trim();
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
            } while (!isRecognizedOperator(calculationStack.peek()) && onpEquation.length() != 0);
            if (isRecognizedOperator(calculationStack.peek()))
                executeCurrentOperation(calculationStack);
        }

        return new BigDecimal(calculationStack.pop()).stripTrailingZeros().toPlainString();
    }

    boolean isRecognizedOperator(String characterToBeRecognized) {
        return mathematicalOperationMap.get(characterToBeRecognized) != null;

    }

    private void executeCurrentOperation(Stack<String> stack) {
        MathematicalOperation mathematicalOperation = getProperOperation(stack.pop());
        String b = stack.pop();
        String a = stack.pop();
        stack.push(mathematicalOperation.calculate(a, b));
    }


    void addMathemacticalOperation(String operationSign, MathematicalOperation mathematicalOperation) {
        this.mathematicalOperationMap.put(operationSign, mathematicalOperation);
    }

    MathematicalOperation getProperOperation(String operator) {
        return this.mathematicalOperationMap.get(operator);
    }
}
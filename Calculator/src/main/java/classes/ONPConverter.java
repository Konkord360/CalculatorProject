package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * converts for handling ONP conversion
 */
 class ONPConverter {
     /**
      * Converts given equation from normal format to ONP
      * @param equationToBeConverted mathematical equation
      * @return mathematical equation in ONP format
      */
    static String convertEquationToONP(String equationToBeConverted) {
        List<String> equationParts = putEveryPartOfEquationIntoList(equationToBeConverted);
        Stack<String> stack = new Stack<>();
        StringBuilder out = new StringBuilder();
        for (String equationPart : equationParts)
            switch (equationPart) {
                case "+":
                    while (!stack.empty() && (stack.peek().equals("x") || stack.peek().equals("/") || stack.peek().equals("-"))) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    out.append(" ");
                    stack.push(equationPart);
                    break;
                case "-":
                    while (!stack.empty() && (stack.peek().equals("x") || stack.peek().equals("/") || stack.peek().equals("+"))) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    out.append(" ");
                    stack.push(equationPart);
                    break;
                case "x":
                    while (!stack.empty() && stack.peek().equals("/")) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    out.append(" ");
                    stack.push(equationPart);
                    break;
                case "/":
                    while (!stack.empty() && stack.peek().equals("x")) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    out.append(" ");
                    stack.push(equationPart);
                    break;
                case "(":
                    stack.push(equationPart);
                    break;
                case ")":
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    out.append(equationPart);
                    break;
            }

        while (!stack.isEmpty())
            out.append(' ').append(stack.pop());

        return out.toString();
    }

     /**
      * Separates every sign from equation to a list
      * @param equation  mathematical equation
      * @return Mathematical equation separated sign by sign
      */
    static List<String> putEveryPartOfEquationIntoList(String equation) {
        List<String> equationList = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        Pattern digitPattern = Pattern.compile("(\\d)|(\\.)");
        Matcher matcher;

        for (char character : equation.replaceAll("\\s+", "").toCharArray()) {
            matcher = digitPattern.matcher(String.valueOf(character));
            if (matcher.matches())
                number.append(String.valueOf(character));
            else{
                if(number.length() != 0)
                    equationList.add(String.valueOf(number));
                number.setLength(0);
                equationList.add(String.valueOf(character));
            }
        }
        equationList.add(String.valueOf(number));
        return equationList;
    }
}

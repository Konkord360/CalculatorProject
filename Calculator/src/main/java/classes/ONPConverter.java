package classes;

import com.sun.prism.shader.AlphaOne_ImagePattern_AlphaTest_Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ONPConverter {
    private String normalEqiation;
    private String onpEquation;
//TODO poprawić bo brzydkie
    public ONPConverter() {
        normalEqiation = "";
        onpEquation = "";
    }

    static String convertEquationToONP(String equationToBeConverted) {
        //List<String> convertedEquation = new ArrayList<>();//TODO dopracować algorytm.
        List<String> equationParts = putEveryPartOfEquationIntoList(equationToBeConverted);
        Stack stack = new Stack();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < equationParts.size(); i++)
            switch (equationParts.get(i)) {
                case "+":
                case "-":
                    while (!stack.empty() && (stack.peek().equals("x") || stack.peek().equals("/"))) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    out.append(" ");
                    stack.push(equationParts.get(i));
                    break;
                case "x":
                case "/":
                    out.append(" ");
                    stack.push(equationParts.get(i));
                    break;
                case "(":
                    stack.push(equationParts.get(i));
                    break;
                case ")":
                    while (!stack.empty() && !stack.peek().equals("(")) {
                        out.append(" ");
                        out.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    out.append(equationParts.get(i));
                    break;
            }

        while (!stack.isEmpty())
            out.append(' ').append(stack.pop());

        return out.toString();
    }

    public static String convertEquationFromONPToNormal(String onpEquation) {
        String normalEquation = "";

        return onpEquation;
    }

    static List<String> putEveryPartOfEquationIntoList(String equation) {
        List<String> equationList = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        Pattern digitPattern = Pattern.compile("(\\d)|(,)");
        Matcher matcher;

        for (char character : equation.replaceAll("\\s+", "").concat("X").toCharArray()) {
            matcher = digitPattern.matcher(String.valueOf(character));
            if (matcher.matches())
                number.append(String.valueOf(character));
            else {
                equationList.add(String.valueOf(number));
                number.setLength(0);
                if (character != 'X')
                    equationList.add(String.valueOf(character));
            }
        }

        return equationList;
    }
}

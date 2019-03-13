package classes;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ONPConverterTests {
    @Test
    public void checkIfONPConverterConvertsSimpleEquationsProperly() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(ONPConverter.convertEquationToONP("3 + 2")).isEqualTo("3 2 +");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("52+(1+2)*4-3")).isEqualTo("52 1 2 + 4 * 3 - +");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("52+((1+2)*4)-3")).isEqualTo("52 1 2 + 4 * 3 - +");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("(52+1+2)*4-3")).isEqualTo("52 1 2 + + 4 * 3 -");
        softAssertions.assertAll();
    }

    @Test
    public void checkIf() {
        Character character;
    }


    @Test
    public void checkIfCalculatorCanProperlySplitEquationIntoParts() {
        CalculatorModel calculatorModel = new CalculatorModel();
        String equation = "3 + 2 - 1";
        List<String> equationList = ONPConverter.putEveryPartOfEquationIntoList(equation);

        assertThat(equationList.get(0)).isEqualTo("3");
        assertThat(equationList.get(1)).isEqualTo("+");
        assertThat(equationList.get(2)).isEqualTo("2");
        assertThat(equationList.get(3)).isEqualTo("-");
        assertThat(equationList.get(4)).isEqualTo("1");
    }
}

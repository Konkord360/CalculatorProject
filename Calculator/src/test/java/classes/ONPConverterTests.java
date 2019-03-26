package classes;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ONPConverterTests {
    @Test
    public void checkIfONPConverterConvertsSimpleEquationsProperly() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(ONPConverter.convertEquationToONP("(52+1+2)x4-3.5")).isEqualTo("52 1 2 + + 4 x 3.5 -");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("3 + 2")).isEqualTo("3 2 +");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("52+(1+2)x4-3")).isEqualTo("52 1 2 + 4 x + 3 -");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("52+((1+2)x4)-3")).isEqualTo("52 1 2 + 4 x + 3 -");
        softAssertions.assertThat(ONPConverter.convertEquationToONP("(52+1+2)x4-3")).isEqualTo("52 1 2 + + 4 x 3 -");
        softAssertions.assertAll();
    }

    @Test
    public void checkIfONPConverterConvertsComplicatedEquation() {
        assertThat(ONPConverter.convertEquationToONP("(3 + 2) x (3 + 1) / 2 - 4 / 2 + (3 + 4 x (2 + 3))")).isEqualTo("3 2 + 3 1 + x 2 / 4 2 / - 3 4 2 3 + x + +");
    }

    @Test
    public void checkIfCalculatorCanProperlySplitEquationIntoParts() {
        String equation = "3 + 2 - 1";
        List<String> equationList = ONPConverter.putEveryPartOfEquationIntoList(equation);

        assertThat(equationList.get(0)).isEqualTo("3");
        assertThat(equationList.get(1)).isEqualTo("+");
        assertThat(equationList.get(2)).isEqualTo("2");
        assertThat(equationList.get(3)).isEqualTo("-");
        assertThat(equationList.get(4)).isEqualTo("1");
    }
}
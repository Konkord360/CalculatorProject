package mathematicalOperations;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * class for handling division
 */
public class DivideOperation implements MathematicalOperation {
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).divide(new BigDecimal(b), 5, RoundingMode.CEILING).toString();
    }
}

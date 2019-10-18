package mathematicalOperations;

import java.math.BigDecimal;

/**
 * class for handling subtraction
 */
public class SubtractOperation implements MathematicalOperation {
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).subtract(new BigDecimal(b)).toString();
    }
}

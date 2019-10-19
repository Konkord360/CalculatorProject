package mathematicalOperations;

import java.math.BigDecimal;

/**
 * class for handling multiplication
 */
public class MultiplyOperation implements MathematicalOperation {
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).multiply(new BigDecimal(b)).toString();
    }
}

package mathematicalOperations;

import java.math.BigDecimal;

/**
 * class for handling addition
 */
public class AddOperation implements MathematicalOperation {
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toString();
    }
}

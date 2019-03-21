package mathematicalOperations;

import java.math.BigDecimal;

public class DivideOperation implements MathematicalOperation {
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).divide(new BigDecimal(b)).toString();
    }
}

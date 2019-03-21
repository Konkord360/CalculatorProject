package mathematicalOperations;

import java.math.BigDecimal;

public class SubrtactOperation implements MathematicalOperation{
    @Override
    public String calculate(String a, String b) {
        return new BigDecimal(a).subtract(new BigDecimal(b)).toString();
    }
}

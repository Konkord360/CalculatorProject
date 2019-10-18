package mathematicalOperations;

/**
 * Interface for abstract factory of mathematical operations
 */
public interface MathematicalOperation {
     /**
      * @param a first part of equation
      * @param b second part of equation
      * @return result of specified equation
      */
     String calculate(String a, String b);
}


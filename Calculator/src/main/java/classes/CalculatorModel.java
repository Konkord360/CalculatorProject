package classes;

public class CalculatorModel {
    String result;
    String equation;


    CalculatorModel(){
    }

    void calculate(String equation){
        this.equation = equation;
        this.result = "";
    }

    public String getResult(){
        return this.result;
    }
}

import calculatorlab5.*;

public static void main(String[] args){
    Calculator calculator = new Calculator(10);
    int result = calculator.add(5).subtract(3).multiply(2).result();
    System.out.println("Problema 1:");
    System.out.println("a) " + result);

    NewIntCalculator intCalc = new NewIntCalculator(10);
    intCalc.init(10);
    int intResult = (int) intCalc.add(5).subtract(3).multiply(2).result();
    System.out.println("Problema 2:");
    System.out.println("intreg: " + intResult);

    DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
    double doubleResult = (double) doubleCalc.add(5).subtract(3.3).multiply(2.2).result();
    System.out.println("Rezultat Double: " + doubleResult);
}
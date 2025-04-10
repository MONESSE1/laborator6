package calculatorlab5;

public class Main {
    public static void main(String[] args) {
        // Problema 1 — folosim NewIntCalculator în loc de "Calculator"
        NewIntCalculator calculator = new NewIntCalculator(10);
        int result = (int) calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("Problema 1:");
        System.out.println("a) " + result);

        // Problema 2 — init cu UN argument
        NewIntCalculator intCalc = new NewIntCalculator(10);
        intCalc.init(23); // înlocuit init(10, 23)
        int intResult = (int) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Problema 2:");
        System.out.println("intreg: " + intResult);

        // Problema 3 — DoubleCalculator
        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double doubleResult = (double) doubleCalc.add(5).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultat Double: " + doubleResult);
    }
}

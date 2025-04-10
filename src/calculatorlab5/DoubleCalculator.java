package calculatorlab5;

public class DoubleCalculator extends ACalculator {

    public DoubleCalculator(Double initialState) {
        super(initialState);
    }

    @Override
    public void init(Object value) {
        if (value instanceof Double) {
            this.state = value;
        } else {
            throw new IllegalArgumentException("nu e double");
        }
    }

    public DoubleCalculator add(double value) {
        this.state = (Double) this.state + value;
        return this;
    }

    public DoubleCalculator subtract(double value) {
        this.state = (Double) this.state - value;
        return this;
    }

    public DoubleCalculator multiply(double value) {
        this.state = (Double) this.state * value;
        return this;
    }

    public DoubleCalculator divide(double value) {
        if (value == 0.0) {
            throw new ArithmeticException("Impartire la zero!");
        }
        this.state = (Double) this.state / value;
        return this;
    }

}



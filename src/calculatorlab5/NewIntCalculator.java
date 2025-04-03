package calculatorlab5;

public class NewIntCalculator extends ACalculator {

    public NewIntCalculator(Integer initialState) {
        super(initialState);
    }

    @Override
    public void init(Object value) {
        if (value instanceof Integer) {
            this.state = value;
        } else {
            throw new IllegalArgumentException("nu e intreaga");
        }
    }

    public NewIntCalculator add(int value) {
        this.state = (Integer) this.state + value;
        return this;
    }

    public NewIntCalculator subtract(int value) {
        this.state = (Integer) this.state - value;
        return this;
    }

    public NewIntCalculator multiply(int value) {
        this.state = (Integer) this.state * value;
        return this;
    }
}
package calculatorlab5;

public abstract class ACalculator {
    protected Object state;


    public ACalculator(Object initialState) {
        this.state = initialState;
    }


    public Object result() {
        return state;
    }


    public ACalculator clear() {
        this.state = 0;
        return this;
    }


    public abstract void init(Object value);
}

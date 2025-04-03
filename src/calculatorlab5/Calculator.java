package calculatorlab5;

public class Calculator{
    protected int value;

    public Calculator(int value){
        this.value =value;
    }

    public Calculator add(int num){
        this.value += num;
        return this;
    }

    public Calculator subtract(int num){
        this.value -= num;
        return this;
    }

    public Calculator multiply(int num){
        this.value *= num;
        return this;
    }

    public int result(){
        return this.value;
    }

}
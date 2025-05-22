package ro.ulbs.paradigme.lab10.dataprocessing;

import ro.ulbs.paradigme.lab10.storage.SensorData;

public class StepCountStrategy {

    public enum StrategyType {
        BASIC,
        FILTERED
    }

    private int numarPasi = 0;
    private final StrategyType strategyType;

    public StepCountStrategy(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    public void consumeMessage(SensorData sample) {
        if (sample != null) {
            int steps = sample.getStepsCount();
            if (strategyType == StrategyType.BASIC) {
                numarPasi += steps;
            } else if (strategyType == StrategyType.FILTERED && steps > 0) {
                numarPasi += steps;
            }
        }
    }

    public int getTotalSteps() {
        return numarPasi;
    }

    public String getStrategyDescription() {
        return strategyType == StrategyType.BASIC
                ? "Basic strategy:"
                : "Filtered strategy:";
    }
}

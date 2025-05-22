package ro.ulbs.paradigme.lab10.main;

import ro.ulbs.paradigme.lab10.dataprocessing.StepCountStrategy;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }

    public static StepCountStrategy getStrategy(String type) {
        if (BASIC_STRATEGY.equalsIgnoreCase(type)) {
            return new StepCountStrategy(StepCountStrategy.StrategyType.BASIC);
        } else if (FILTERED_STRATEGY.equalsIgnoreCase(type)) {
            return new StepCountStrategy(StepCountStrategy.StrategyType.FILTERED);
        } else {
            throw new IllegalArgumentException("Unknown strategy type: " + type);
        }
    }
}

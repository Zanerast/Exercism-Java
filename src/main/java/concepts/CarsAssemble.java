package concepts;

public class CarsAssemble {

    private static final int PRODUCTION_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        return speed * successRate(speed) * PRODUCTION_PER_HOUR;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) / 60;
    }

    private double successRate(int speed){
        double successRate = 1.0;
        if (speed > 9){
            successRate =  0.77;
        } else if(speed >8){
            successRate = 0.8;
        } else if (speed > 4){
            successRate = 0.9;
        }
        return successRate;
    }
}

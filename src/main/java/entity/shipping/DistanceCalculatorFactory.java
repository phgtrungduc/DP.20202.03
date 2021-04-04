package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceCalculatorFactory {
    public DistanceCalculator createDistanceCalculator(){
        return new DistanceCalculator();
    }
}

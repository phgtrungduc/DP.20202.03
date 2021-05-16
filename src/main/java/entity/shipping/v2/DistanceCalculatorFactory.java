package entity.shipping.v2;

import org.example.DistanceCalculator;

public class DistanceCalculatorFactory {
    public DistanceCalculator createDistanceCalculator(){
        return new DistanceCalculator();
    }
}

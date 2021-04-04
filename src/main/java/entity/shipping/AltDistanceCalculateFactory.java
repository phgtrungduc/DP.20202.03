package entity.shipping;

import org.example.DistanceCalculator;

public class AltDistanceCalculateFactory extends DistanceCalculatorFactory{
    @Override
    public AltDistanceCalculate createDistanceCalculator() {
        return new AltDistanceCalculate();
    }
}

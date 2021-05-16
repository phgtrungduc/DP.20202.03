package entity.shipping.v2;

public class AltDistanceCalculateFactory extends DistanceCalculatorFactory {
    @Override
    public AltDistanceCalculate createDistanceCalculator() {
        return new AltDistanceCalculate();
    }
}

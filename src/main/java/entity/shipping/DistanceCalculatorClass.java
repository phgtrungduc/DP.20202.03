package entity.shipping;

import org.example.AlternativeDistanceCalculator;
import org.example.DistanceCalculator;

public class DistanceCalculatorClass implements DistanceBehavior{
    private DistanceCalculator distanceCalculator;

    public DistanceCalculatorClass(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    @Override
    public int calculateShippingFee(String address, String province) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }
}

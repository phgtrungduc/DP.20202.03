package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceAPIFactory extends DistanceFactory {
    @Override
    public DistanceCalculator createDistanceCalculator() {
        return new DistanceCalculator();
    }
}

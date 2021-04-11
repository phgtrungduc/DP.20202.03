package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceAPIFactory implements DistanceFactory {
    @Override
    public DistanceCalculator createDistanceCalculator() {
        return new DistanceCalculator();
    }
}

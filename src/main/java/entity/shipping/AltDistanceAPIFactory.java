package entity.shipping;

import org.example.DistanceCalculator;

public class AltDistanceAPIFactory extends DistanceFactory {
    @Override
    public DistanceCalculator createDistanceCalculator() {
        return super.createDistanceCalculator();//cho nay thay bang return new AltDistanceAPI();
    }
}

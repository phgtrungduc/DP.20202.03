package entity.shipping.CalculateShippingFeeStrategy;

import org.example.DistanceCalculator;

public class CalculateShippingFee_v1 extends ACalculateShippingFee {
    public CalculateShippingFee_v1(DistanceCalculator distanceCalculator) {
        super(distanceCalculator);
    }
    @Override
    public int calculateShippingFee(String address,String province) {
        return distanceCalculator.calculateDistance(address,province);
    }
}

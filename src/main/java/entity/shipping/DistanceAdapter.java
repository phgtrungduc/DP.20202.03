package entity.shipping;

import org.example.AlternativeDistanceCalculator;

public class DistanceAdapter implements DistanceBehavior {
    private AlternativeDistanceCalculator alternativeDistanceCalculator;

    public DistanceAdapter(AlternativeDistanceCalculator alternativeDistanceCalculator) {
        this.alternativeDistanceCalculator = alternativeDistanceCalculator;
    }

    @Override
    public int calculateShippingFee(String address, String province) {
        String fullAddress = address + " " + province;
        alternativeDistanceCalculator.calculateDistance(fullAddress);
        return 0;
    }
}

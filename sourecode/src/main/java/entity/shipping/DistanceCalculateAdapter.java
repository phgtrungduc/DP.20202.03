package entity.shipping;

import org.example.AlternativeDistanceCalculator;
import org.example.DistanceCalculator;

public class DistanceCalculateAdapter extends DistanceCalculator {
    AlternativeDistanceCalculator alternativeDistanceCalculator;

    public DistanceCalculateAdapter(AlternativeDistanceCalculator alternativeDistanceCalculator) {
        this.alternativeDistanceCalculator = alternativeDistanceCalculator;
    }

    @Override
    public int calculateDistance(String address, String province) {
        return alternativeDistanceCalculator.calculateDistance(address+ province);
    }
}

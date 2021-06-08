package entity.shipping.calculateshippingfee;

import org.example.AlternativeDistanceCalculator;

public class CalculateDistanceFeeWithDemension implements ICalculateDistanceFee {
    @Override
    public int calculateDistance(String address, String province) {
        AlternativeDistanceCalculator  altDistanceCalculatortance = new AlternativeDistanceCalculator();
        int distance =   altDistanceCalculatortance.calculateDistance(address +province);
        return distance;
    }
}

package entity.shipping.calculateshippingfee;

import org.example.DistanceCalculator;

public class CalculateDistanceFee implements ICalculateDistanceFee {


    @Override
    public int calculateDistance(String address, String province) {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int distance =   distanceCalculator.calculateDistance(address,province);
        return distance;
    }
}

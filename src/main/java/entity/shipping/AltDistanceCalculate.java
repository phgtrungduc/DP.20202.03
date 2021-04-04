package entity.shipping;

import org.example.DistanceCalculator;
import org.example.ShippingConfigs;

import java.util.Arrays;
import java.util.Random;

public class AltDistanceCalculate extends DistanceCalculator {
    public double calculateDistance(String address,String province,double length,double width,double height) {
        Random rand = new Random();
        if (Arrays.asList(ShippingConfigs.PROVINCES).contains(province)) {
            return address.length() + (int)(rand.nextFloat() * 10.0F) / 100;
        } else {
            throw new IllegalArgumentException("Province does not exist!");
        }
    }
}

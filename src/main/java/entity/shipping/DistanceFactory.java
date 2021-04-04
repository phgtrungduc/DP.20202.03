package entity.shipping;

import org.example.DistanceCalculator;

public class DistanceFactory {
    public DistanceCalculator createDistanceCalculator(){
        return new DistanceCalculator();
    }
}

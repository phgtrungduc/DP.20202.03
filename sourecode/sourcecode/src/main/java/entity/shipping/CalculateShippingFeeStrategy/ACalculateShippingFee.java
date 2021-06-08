package entity.shipping.CalculateShippingFeeStrategy;

import entity.shipping.calculateshippingfee.ICalculateDistanceFee;
import org.example.DistanceCalculator;

public abstract class ACalculateShippingFee {
        DistanceCalculator distanceCalculator;
        public ACalculateShippingFee(DistanceCalculator distanceCalculator){
                this.distanceCalculator = distanceCalculator;
        }
        public abstract int calculateShippingFee(String address,String province);
}

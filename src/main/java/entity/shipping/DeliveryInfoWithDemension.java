package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class DeliveryInfoWithDemension extends DeliveryInfo {
    private double length;
    private double width;
    private double height;
    private double weight;


    public DeliveryInfoWithDemension(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator, double length, double width, double height, double weight) {
        super(name, phone, province, address, shippingInstructions, distanceCalculator);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public double calculateBulky(){
        return (this.height*this.width*this.length)/6000;
    }

    @Override
    public int calculateShippingFee(Order order) {
        int distance = distanceCalculator.calculateDistance(this.address,this.province);
        if (this.distanceCalculator instanceof DistanceCalculateAdapter)  {
            double bulky = calculateBulky();//độ cồng kềnh
            double fee = bulky*10+this.weight + distance;
            return (int)fee;
        }else{
            return  super.calculateShippingFee(order);
        }

    }
}

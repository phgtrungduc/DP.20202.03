package entity.shipping.v3WithStrategy;

import entity.order.Order;
import entity.shipping.calculateshippingfee.CalculateDistanceFeeWithDemension;
import entity.shipping.v3WithStrategy.DeliveryInfo;

public class DeliveryInfoWithDemension extends DeliveryInfo {
    private double length;
    private double width;
    private double height;
    private double weight;
    public DeliveryInfoWithDemension(String name, String phone, String province, String address, String shippingInstructions) {
        super(name, phone, province, address, shippingInstructions);
    }

    public DeliveryInfoWithDemension(String name, String phone, String province, String address, String shippingInstructions, double length, double width, double height,double weight) {
        super(name, phone, province, address, shippingInstructions);
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int calculateShippingFee(Order order) {
        setCalculateDistance(new CalculateDistanceFeeWithDemension());
        int distance = iCalculateDistanceFee.calculateDistance(this.address,this.province);
        double bulky = (this.height*this.width*this.length)/6000;//độ cồng kềnh
        double fee = bulky*10+this.weight + distance;
        return (int)fee;
    }
}

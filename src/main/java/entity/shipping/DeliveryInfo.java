package entity.shipping;

import entity.order.Order;
import entity.shipping.calculateshippingfee.CalculateDistanceFee;
import entity.shipping.calculateshippingfee.ICalculateDistanceFee;
import org.example.DistanceCalculator;

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected ICalculateDistanceFee iCalculateDistanceFee;
    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
    }

    public int calculateShippingFee(Order order) {
        this.setCalculateDistance(new CalculateDistanceFee());
        int distance = iCalculateDistanceFee.calculateDistance(this.address,this.province);
        return (int)(1.2*distance);
    }
    public void setCalculateDistance(ICalculateDistanceFee iCalculateDistanceFee){
        this.iCalculateDistanceFee = iCalculateDistanceFee;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
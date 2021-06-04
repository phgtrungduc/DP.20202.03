package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
//    protected DistanceCalculator distanceCalculator;

    protected DistanceBehavior distanceBehavior;
    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceBehavior distanceBehavior) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceBehavior = distanceBehavior;
    }
//    protected DistanceCalculator distanceCalculator;
//    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
//        this.name = name;
//        this.phone = phone;
//        this.province = province;
//        this.address = address;
//        this.shippingInstructions = shippingInstructions;
//        this.distanceCalculator = distanceCalculator;
//    }
    //SOLID: Vi phạm nguyên tắc OCP vì khi muốn đổi sang cách tính phí giao hàng khác thì phải sửa các lớp khác
    public int calculateShippingFee(Order order) {
       return distanceBehavior.calculateShippingFee(address, province);
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

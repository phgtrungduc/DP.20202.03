package entity.shipping;

import entity.shipping.CalculateShippingFeeStrategy.CalculateShippingFee_v1;
import entity.shipping.CalculateShippingFeeStrategy.ACalculateShippingFee;
import org.example.DistanceCalculator;

public class DeliveryInfo {

    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;
    protected ACalculateShippingFee sCalculateShippingFee;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }
    public void setCalculateShippingFee(ACalculateShippingFee sCalculateShippingFee){
        this.sCalculateShippingFee = sCalculateShippingFee;
    }
    public int calculateShippingFee() {
        this.setCalculateShippingFee(new CalculateShippingFee_v1(distanceCalculator));
        return sCalculateShippingFee.calculateShippingFee(address, province);
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
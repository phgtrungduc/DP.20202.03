package entity.shipping;

import org.example.DistanceCalculator;

public class DeliveryInfoWithDimension extends DeliveryInfo{
    private double lenght;
    private double width;
    private double height;

    public DeliveryInfoWithDimension(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculatorFactory distanceCalculatorFactory) {
        super(name, phone, province, address, shippingInstructions, distanceCalculatorFactory);
    }

    public DeliveryInfoWithDimension(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculatorFactory distanceCalculatorFactory, double lenght, double width, double height) {
        super(name, phone, province, address, shippingInstructions, distanceCalculatorFactory);
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }
}

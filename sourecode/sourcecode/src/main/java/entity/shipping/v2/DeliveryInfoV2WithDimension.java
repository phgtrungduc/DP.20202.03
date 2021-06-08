package entity.shipping.v2;

public class DeliveryInfoV2WithDimension extends DeliveryInfo_v2 {
    private double lenght;
    private double width;
    private double height;

    public DeliveryInfoV2WithDimension(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculatorFactory distanceCalculatorFactory) {
        super(name, phone, province, address, shippingInstructions, distanceCalculatorFactory);
    }

    public DeliveryInfoV2WithDimension(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculatorFactory distanceCalculatorFactory, double lenght, double width, double height) {
        super(name, phone, province, address, shippingInstructions, distanceCalculatorFactory);
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }
}

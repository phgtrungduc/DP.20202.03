package entity.shipping;

public class DeliverInfoVersionTwoFactory implements DeliveryInfoFactory{
    public DeliverInfoVersionTwo getDeliverInfo(String name, String phone, String province, String address, String shippingInstructions) {
        return new DeliverInfoVersionTwo(name, phone, province, address, shippingInstructions);
    }
}

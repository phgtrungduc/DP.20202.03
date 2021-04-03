package entity.shipping;

public class DeliverInfoVersionOneFactory implements DeliveryInfoFactory {
    public DeliverInfoVersionOne getDeliverInfo(String name, String phone, String province, String address, String shippingInstructions) {
        return new DeliverInfoVersionOne(name, phone, province, address, shippingInstructions);
    }
}

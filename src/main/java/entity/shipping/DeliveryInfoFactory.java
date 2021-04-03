package entity.shipping;

public interface DeliveryInfoFactory {
    public DeliveryInfo getDeliverInfo(String name, String phone, String province, String address, String shippingInstructions);
}

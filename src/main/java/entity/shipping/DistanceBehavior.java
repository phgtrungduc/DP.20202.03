package entity.shipping;

public interface DistanceBehavior {
    int calculateShippingFee(String address, String province);
}

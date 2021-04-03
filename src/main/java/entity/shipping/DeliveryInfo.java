package entity.shipping;


import entity.order.Order;

public abstract class DeliveryInfo {
    public abstract String getName();

    public abstract String getPhone();

    public abstract String getProvince();

    public abstract String getAddress();

    public abstract String getShippingInstructions();

    public abstract  int calculateShippingFee(Order order);
}
